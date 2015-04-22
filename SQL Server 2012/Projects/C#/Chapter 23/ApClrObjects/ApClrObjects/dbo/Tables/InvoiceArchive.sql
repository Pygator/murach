/****** Object:  Table [dbo].[InvoiceArchive]    Script Date: 5/2/2012 3:17:14 PM ******/
CREATE TABLE [dbo].[InvoiceArchive](
	[InvoiceID] [int] NOT NULL,
	[VendorID] [int] NOT NULL,
	[InvoiceNumber] [varchar](50) NOT NULL,
	[InvoiceDate] [smalldatetime] NOT NULL,
	[InvoiceTotal] [money] NOT NULL,
	[PaymentTotal] [money] NOT NULL,
	[CreditTotal] [money] NOT NULL,
	[TermsID] [int] NOT NULL,
	[InvoiceDueDate] [smalldatetime] NOT NULL,
	[PaymentDate] [smalldatetime] NULL
) ON [PRIMARY]