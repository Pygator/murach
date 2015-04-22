/****** Object:  Table [dbo].[GLAccounts]    Script Date: 5/2/2012 3:17:14 PM ******/
CREATE TABLE [dbo].[GLAccounts](
	[AccountNo] [int] NOT NULL,
	[AccountDescription] [varchar](50) NOT NULL,
 CONSTRAINT [PK_GLAccounts] PRIMARY KEY CLUSTERED 
(
	[AccountNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]