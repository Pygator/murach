var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        var result = xhr.responseText;
        var object = JSON.parse(result);
        postMessage(object);
    }			
}
xhr.open("GET", "data/books.json", true);
xhr.send("");