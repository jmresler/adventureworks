USE [AdventureWorks2017]
GO

IF EXISTS (SELECT name FROM sys.schemas WHERE name = N'System')
BEGIN
	PRINT 'Dropping the System schema'
	DROP SCHEMA [System]
END
GO
PRINT 'Creating the System schema'
GO
CREATE SCHEMA [System] AUTHORIZATION [dbo]
GO

/****** Object:  Table [System].[MOTD]    Script Date: 5/18/2020 3:46:53 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [System].[MOTD](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[message] [nvarchar](max) NOT NULL,
	[start_date] [datetime] NOT NULL,
	[end_date] [datetime] NOT NULL,
	[priority] [int] NOT NULL,
	[last_update] [datetime] NOT NULL,
 CONSTRAINT [PK_MOTD] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [System].[MOTD] ADD  DEFAULT (getdate()) FOR [last_update]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Last time this row was editied' , @level0type=N'SCHEMA',@level0name=N'System', @level1type=N'TABLE',@level1name=N'MOTD', @level2type=N'COLUMN',@level2name=N'last_update'
GO


