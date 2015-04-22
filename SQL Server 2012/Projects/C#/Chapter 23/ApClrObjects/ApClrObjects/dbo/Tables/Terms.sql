/****** Object:  Table [dbo].[Terms]    Script Date: 5/2/2012 3:17:14 PM ******/
CREATE TABLE [dbo].[Terms](
	[TermsID] [int] IDENTITY(1,1) NOT NULL,
	[TermsDescription] [varchar](50) NOT NULL,
	[TermsDueDays] [smallint] NOT NULL,
 CONSTRAINT [PK_Terms] PRIMARY KEY CLUSTERED 
(
	[TermsID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]