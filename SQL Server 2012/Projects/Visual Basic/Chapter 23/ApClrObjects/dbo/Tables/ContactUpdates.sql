/****** Object:  Table [dbo].[ContactUpdates]    Script Date: 5/2/2012 3:17:14 PM ******/
CREATE TABLE [dbo].[ContactUpdates](
	[VendorID] [int] IDENTITY(1,1) NOT NULL,
	[LastName] [varchar](50) NULL,
	[FirstName] [varchar](50) NULL
) ON [PRIMARY]