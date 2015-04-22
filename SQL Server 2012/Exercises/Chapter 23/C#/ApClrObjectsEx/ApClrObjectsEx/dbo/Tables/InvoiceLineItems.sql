/****** Object:  Table [dbo].[InvoiceLineItems]    Script Date: 5/2/2012 3:17:14 PM ******/
CREATE TABLE [dbo].[InvoiceLineItems](
	[InvoiceID] [int] NOT NULL,
	[InvoiceSequence] [smallint] NOT NULL,
	[AccountNo] [int] NOT NULL,
	[InvoiceLineItemAmount] [money] NOT NULL,
	[InvoiceLineItemDescription] [varchar](100) NOT NULL,
 CONSTRAINT [PK_InvoiceLineItems] PRIMARY KEY CLUSTERED 
(
	[InvoiceID] ASC,
	[InvoiceSequence] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[InvoiceLineItems]  ADD  CONSTRAINT [FK_InvoiceLineItems_GLAccounts] FOREIGN KEY([AccountNo])
REFERENCES [dbo].[GLAccounts] ([AccountNo])
ON UPDATE CASCADE
GO

ALTER TABLE [dbo].[InvoiceLineItems] CHECK CONSTRAINT [FK_InvoiceLineItems_GLAccounts]
GO
ALTER TABLE [dbo].[InvoiceLineItems]  ADD  CONSTRAINT [FK_InvoiceLineItems_Invoices] FOREIGN KEY([InvoiceID])
REFERENCES [dbo].[Invoices] ([InvoiceID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[InvoiceLineItems] CHECK CONSTRAINT [FK_InvoiceLineItems_Invoices]
GO
/****** Object:  Index [IX_InvoiceLineItems_AccountNo]    Script Date: 5/2/2012 3:17:14 PM ******/
CREATE NONCLUSTERED INDEX [IX_InvoiceLineItems_AccountNo] ON [dbo].[InvoiceLineItems]
(
	[AccountNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]