import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.xml.stream.*;  // StAX API

public class ProductXMLFile implements ProductDAO
{
    private Path productsPath = null;
    private ArrayList<Product> products = null;

    public ProductXMLFile()
    {
        productsPath = Paths.get("products.xml");
        products = this.getProducts();
    }
    private boolean saveProducts()
    {
        // create the XMLOutputFactory object
        XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
        try
        {
            // create XMLStreamWriter object
            FileWriter fileWriter =
                new FileWriter(productsPath.toFile());
            XMLStreamWriter writer =
                outputFactory.createXMLStreamWriter(fileWriter);

            //write the products to the file
            writer.writeStartDocument("1.0");
            writer.writeStartElement("Products");
            for (Product p : products)
            {
                writer.writeStartElement("Product");
                writer.writeAttribute("Code", p.getCode());

                writer.writeStartElement("Description");
                writer.writeCharacters(p.getDescription());
                writer.writeEndElement();

                writer.writeStartElement("Price");
                double price = p.getPrice();
                writer.writeCharacters(Double.toString(price));
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.flush();
            writer.close();
        }
        catch (IOException | XMLStreamException e)
        {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public ArrayList<Product> getProducts()
    {
        // if the XML file has already been read, don't read it again
        if (products != null)
            return products;        

        products = new ArrayList<>();        
        Product p = null;        
        if (Files.exists(productsPath))  // prevent the FileNotFoundException
        {
            // create the XMLInputFactory object
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            try
            {
                // create a XMLStreamReader object
                FileReader fileReader =
                    new FileReader(productsPath.toFile());
                XMLStreamReader reader =
                    inputFactory.createXMLStreamReader(fileReader);

                // read the products from the file
                while (reader.hasNext())
                {
                    int eventType = reader.getEventType();
                    switch (eventType)
                    {
                        case XMLStreamConstants.START_ELEMENT:
                            String elementName = reader.getLocalName();
                            if (elementName.equals("Product"))
                            {
                                p = new Product();
                                String code = reader.getAttributeValue(0);
                                p.setCode(code);
                            }
                            if (elementName.equals("Description"))
                            {
                                String description = reader.getElementText();
                                p.setDescription(description);
                            }
                            if (elementName.equals("Price"))
                            {
                                String priceText = reader.getElementText();
                                double price = Double.parseDouble(priceText);
                                p.setPrice(price);
                            }
                            break;
                        case XMLStreamConstants.END_ELEMENT:
                            elementName = reader.getLocalName();
                            if (elementName.equals("Product"))
                            {
                                products.add(p);
                            }
                            break;
                        default:
                            break;
                    }
                    reader.next();
                }
            }
            catch (IOException | XMLStreamException e)
            {
                System.out.println(e);
                return null;
            }
        }
        return products;
    }

    public Product getProduct(String code)
    {
        for (Product p : products)
        {
            if (p.getCode().equals(code))
                return p;
        }
        return null;
    }

    public boolean addProduct(Product p)
    {
        products.add(p);
        return this.saveProducts();
    }

    public boolean deleteProduct(Product p)
    {
        products.remove(p);
        return this.saveProducts();
    }

    public boolean updateProduct(Product newProduct)
    {
        // get the old product and remove it
        Product oldProduct = this.getProduct(newProduct.getCode());
        int i = products.indexOf(oldProduct);
        products.remove(i);

        // add the updated product
        products.add(i, newProduct);

        return this.saveProducts();
    }
}