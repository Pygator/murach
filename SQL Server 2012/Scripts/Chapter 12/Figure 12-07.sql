USE [New_AP]
GO

/****** Object:  Table [dbo].[Invoices]    Script Date: 6/12/2012 4:00:29 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Invoices](
	[InvoiceID] [int] IDENTITY(1,1) NOT NULL,
	[VendorID] [int] NOT NULL,
	[InvoiceDate] [smalldatetime] NULL,
	[InvoiceTotal] [money] NULL,
 CONSTRAINT [PK_Invoices_1] PRIMARY KEY CLUSTERED 
(
	[InvoiceID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Invoices] ADD  CONSTRAINT [DF_Invoices_InvoiceTotal]  DEFAULT ((0)) FOR [InvoiceTotal]
GO

ALTER TABLE [dbo].[Invoices]  WITH CHECK ADD  CONSTRAINT [FK_Invoices_Vendors] FOREIGN KEY([VendorID])
REFERENCES [dbo].[Vendors] ([VendorID])
GO

ALTER TABLE [dbo].[Invoices] CHECK CONSTRAINT [FK_Invoices_Vendors]
GO

ALTER TABLE [dbo].[Invoices]  WITH CHECK ADD  CONSTRAINT [CK_InvoiceTotal] CHECK  (([InvoiceTotal]>(0)))
GO

ALTER TABLE [dbo].[Invoices] CHECK CONSTRAINT [CK_InvoiceTotal]
GO


