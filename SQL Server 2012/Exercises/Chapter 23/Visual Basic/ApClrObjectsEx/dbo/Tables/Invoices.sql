/****** Object:  Table [dbo].[Invoices]    Script Date: 5/2/2012 3:17:14 PM ******/
CREATE TABLE [dbo].[Invoices](
	[InvoiceID] [int] IDENTITY(1,1) NOT NULL,
	[VendorID] [int] NOT NULL,
	[InvoiceNumber] [varchar](50) NOT NULL,
	[InvoiceDate] [smalldatetime] NOT NULL,
	[InvoiceTotal] [money] NOT NULL,
	[PaymentTotal] [money] NOT NULL,
	[CreditTotal] [money] NOT NULL,
	[TermsID] [int] NOT NULL,
	[InvoiceDueDate] [smalldatetime] NOT NULL,
	[PaymentDate] [smalldatetime] NULL,
 CONSTRAINT [PK_Invoices] PRIMARY KEY CLUSTERED 
(
	[InvoiceID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Invoices]  ADD  CONSTRAINT [FK_Invoices_Terms] FOREIGN KEY([TermsID])
REFERENCES [dbo].[Terms] ([TermsID])
GO

ALTER TABLE [dbo].[Invoices] CHECK CONSTRAINT [FK_Invoices_Terms]
GO
ALTER TABLE [dbo].[Invoices]  ADD  CONSTRAINT [FK_Invoices_Vendors] FOREIGN KEY([VendorID])
REFERENCES [dbo].[Vendors] ([VendorID])
GO

ALTER TABLE [dbo].[Invoices] CHECK CONSTRAINT [FK_Invoices_Vendors]
GO
ALTER TABLE [dbo].[Invoices] ADD  CONSTRAINT [DF_Invoices_PaymentTotal]  DEFAULT (0) FOR [PaymentTotal]
GO
ALTER TABLE [dbo].[Invoices] ADD  CONSTRAINT [DF_Invoices_CreditTotal]  DEFAULT (0) FOR [CreditTotal]
GO
/****** Object:  Index [IX_InvoiceDate]    Script Date: 5/2/2012 3:17:14 PM ******/
CREATE NONCLUSTERED INDEX [IX_InvoiceDate] ON [dbo].[Invoices]
(
	[InvoiceDate] DESC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Invoices_TermsID]    Script Date: 5/2/2012 3:17:14 PM ******/
CREATE NONCLUSTERED INDEX [IX_Invoices_TermsID] ON [dbo].[Invoices]
(
	[TermsID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Invoices_VendorID]    Script Date: 5/2/2012 3:17:14 PM ******/
CREATE NONCLUSTERED INDEX [IX_Invoices_VendorID] ON [dbo].[Invoices]
(
	[VendorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]