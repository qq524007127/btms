USE [btms]
GO
/****** Object:  Table [dbo].[t_user]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_user](
	[userId] [varchar](36) NOT NULL,
	[email] [varchar](50) NULL,
	[mobile] [varchar](20) NULL,
	[password] [varchar](32) NOT NULL,
	[permit] [bit] NOT NULL,
	[remark] [varchar](500) NULL,
	[userCode] [varchar](16) NOT NULL,
	[userName] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[userCode] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_tablet]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_tablet](
	[tabletId] [varchar](36) NOT NULL,
	[editable] [bit] NOT NULL,
	[permit] [bit] NOT NULL,
	[tabletName] [varchar](100) NOT NULL,
	[tabletOverdue] [datetime] NULL,
	[tabletPrice] [float] NOT NULL,
	[tabletRemark] [varchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[tabletId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[tabletName] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_role]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_role](
	[roleId] [varchar](36) NOT NULL,
	[remark] [varchar](100) NULL,
	[roleName] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[roleId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[roleName] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_member]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_member](
	[memberId] [varchar](36) NOT NULL,
	[memberAddress] [varchar](100) NULL,
	[memberBirthday] [datetime] NULL,
	[memberIdentNum] [varchar](18) NULL,
	[memberName] [varchar](50) NOT NULL,
	[memberNatPlace] [varchar](100) NULL,
	[memberNational] [varchar](50) NULL,
	[password] [varchar](32) NOT NULL,
	[permit] [bit] NOT NULL,
	[remark] [varchar](500) NULL,
	[memberSex] [varchar](255) NULL,
	[memberTell] [varchar](11) NULL,
	[memberUnit] [varchar](100) NULL,
	[spareName] [varchar](50) NULL,
	[spareTell] [varchar](11) NULL,
PRIMARY KEY CLUSTERED 
(
	[memberId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_level]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_level](
	[levId] [varchar](36) NOT NULL,
	[levName] [varchar](100) NOT NULL,
	[levPrice] [float] NOT NULL,
	[mng_price] [float] NULL,
	[remark] [varchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[levId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[levName] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_expens_item]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_expens_item](
	[itemId] [varchar](36) NOT NULL,
	[cost_type] [int] NOT NULL,
	[editAble] [bit] NOT NULL,
	[itemName] [varchar](50) NOT NULL,
	[itemPrice] [float] NOT NULL,
	[itemRemark] [varchar](500) NULL,
	[permit] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[itemId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[itemName] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_enterprise]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_enterprise](
	[enterId] [varchar](36) NOT NULL,
	[busLisCode] [varchar](20) NOT NULL,
	[enterAddress] [varchar](150) NULL,
	[enterName] [varchar](50) NOT NULL,
	[enterPermit] [bit] NOT NULL,
	[enterRemark] [varchar](500) NULL,
	[enterTell] [varchar](11) NOT NULL,
	[legalPersonName] [varchar](50) NOT NULL,
	[spareName] [varchar](50) NULL,
	[spareTell] [varchar](11) NULL,
PRIMARY KEY CLUSTERED 
(
	[enterId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_data_summary]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_data_summary](
	[data_id] [varchar](36) NOT NULL,
	[bs_buy_count] [int] NOT NULL,
	[bs_buy_totalprice] [float] NOT NULL,
	[bs_lease_count] [int] NOT NULL,
	[bs_lease_totalprice] [float] NOT NULL,
	[bs_remain] [int] NOT NULL,
	[create_date] [datetime] NOT NULL,
	[item_count] [int] NOT NULL,
	[item_totalprice] [float] NOT NULL,
	[member_count] [int] NOT NULL,
	[mem_totalprice] [float] NOT NULL,
	[mng_rec_count] [int] NOT NULL,
	[mng_totalprice] [float] NOT NULL,
	[blt_buy_count] [int] NOT NULL,
	[tbl_remain] [int] NOT NULL,
	[blt_totalpirce] [float] NOT NULL,
	[total] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[data_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[data_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_constant]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_constant](
	[c_id] [varchar](36) NOT NULL,
	[constant_group] [int] NOT NULL,
	[group_name] [varchar](150) NULL,
	[constant_key] [int] NOT NULL,
	[remark] [varchar](500) NULL,
	[value] [varchar](150) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[c_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_area]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_area](
	[areaId] [varchar](255) NOT NULL,
	[area_column] [int] NOT NULL,
	[name] [varchar](10) NOT NULL,
	[area_row] [int] NOT NULL,
	[coords] [varchar](100) NOT NULL,
	[remark] [varchar](500) NULL,
	[shelf_column] [int] NOT NULL,
	[shelf_row] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[areaId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_adovcater_card]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_adovcater_card](
	[cardId] [varchar](36) NOT NULL,
	[advBirthday] [datetime] NULL,
	[advName] [varchar](25) NOT NULL,
	[cardCode] [varchar](12) NOT NULL,
	[create_date] [datetime] NOT NULL,
	[remark] [varchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[cardId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[cardCode] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[advName] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_module]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_module](
	[module_id] [varchar](36) NOT NULL,
	[moduleName] [varchar](50) NOT NULL,
	[mod_sort] [int] NULL,
	[pageUrl] [varchar](100) NULL,
	[permit] [bit] NOT NULL,
	[remark] [varchar](200) NULL,
	[parsent] [varchar](36) NULL,
PRIMARY KEY CLUSTERED 
(
	[module_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[moduleName] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user_role]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user_role](
	[user_id] [varchar](36) NOT NULL,
	[role_id] [varchar](36) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[role_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_member_card]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_member_card](
	[card_id] [varchar](36) NOT NULL,
	[card_code] [varchar](10) NOT NULL,
	[create_date] [datetime] NULL,
	[permit] [bit] NOT NULL,
	[remark] [varchar](500) NULL,
	[enter_id] [varchar](36) NULL,
	[member_id] [varchar](36) NULL,
PRIMARY KEY CLUSTERED 
(
	[card_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[card_code] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[role_module]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[role_module](
	[role_id] [varchar](36) NOT NULL,
	[module_id] [varchar](36) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC,
	[module_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_relation]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_relation](
	[relId] [varchar](36) NOT NULL,
	[relAddress] [varchar](100) NULL,
	[relBirthday] [datetime] NULL,
	[relName] [varchar](50) NOT NULL,
	[relRemark] [varchar](500) NULL,
	[relSex] [varchar](10) NULL,
	[relTell] [varchar](11) NULL,
	[relation] [varchar](50) NOT NULL,
	[mem_memberId] [varchar](36) NULL,
PRIMARY KEY CLUSTERED 
(
	[relId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_pay_record]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_pay_record](
	[payRecId] [varchar](36) NOT NULL,
	[payDate] [datetime] NULL,
	[total_price] [float] NOT NULL,
	[enter_id] [varchar](36) NULL,
	[member_id] [varchar](36) NULL,
	[user_id] [varchar](36) NULL,
PRIMARY KEY CLUSTERED 
(
	[payRecId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_shelf]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_shelf](
	[shelfId] [varchar](36) NOT NULL,
	[permit] [bit] NOT NULL,
	[postionColumn] [int] NOT NULL,
	[postionRow] [int] NOT NULL,
	[remark] [varchar](500) NULL,
	[shelfCode] [varchar](10) NOT NULL,
	[shelfColumn] [int] NOT NULL,
	[shelfRow] [int] NOT NULL,
	[area_id] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[shelfId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[shelfCode] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_tablet_record]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_tablet_record](
	[tlRecId] [varchar](36) NOT NULL,
	[create_date] [datetime] NOT NULL,
	[length] [int] NOT NULL,
	[overdue] [datetime] NOT NULL,
	[total_price] [float] NOT NULL,
	[enter_id] [varchar](36) NULL,
	[member_id] [varchar](36) NULL,
	[pay_id] [varchar](36) NOT NULL,
	[tablet_id] [varchar](36) NOT NULL,
	[user_id] [varchar](36) NULL,
PRIMARY KEY CLUSTERED 
(
	[tlRecId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_pay_detail]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_pay_detail](
	[detailId] [varchar](36) NOT NULL,
	[cost_type] [int] NOT NULL,
	[total_price] [float] NOT NULL,
	[name] [varchar](200) NOT NULL,
	[time_length] [int] NULL,
	[dueto_date] [datetime] NULL,
	[fg_id] [varchar](50) NULL,
	[price] [float] NOT NULL,
	[pay_id] [varchar](36) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[detailId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_bless_seat]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_bless_seat](
	[bsId] [varchar](36) NOT NULL,
	[bsCode] [varchar](15) NOT NULL,
	[managExpense] [float] NOT NULL,
	[permit] [bit] NOT NULL,
	[remark] [varchar](500) NULL,
	[shelfColumn] [int] NOT NULL,
	[shelfRow] [int] NOT NULL,
	[level_id] [varchar](36) NULL,
	[shelf_id] [varchar](36) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[bsId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[bsCode] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_deader]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_deader](
	[deadId] [varchar](36) NOT NULL,
	[adv_card_code] [varchar](15) NULL,
	[contactAdress] [varchar](150) NULL,
	[contactName] [varchar](50) NOT NULL,
	[contactTell] [varchar](11) NULL,
	[deadAdress] [varchar](100) NULL,
	[deadBirthday] [datetime] NULL,
	[deadName] [varchar](50) NOT NULL,
	[deadNatPlace] [varchar](50) NULL,
	[deadNational] [varchar](50) NULL,
	[deadRemark] [varchar](500) NULL,
	[deadedDate] [datetime] NULL,
	[desSex] [varchar](255) NULL,
	[identNum] [varchar](18) NOT NULL,
	[inputDate] [datetime] NULL,
	[adcard_id] [varchar](36) NULL,
	[card_id] [varchar](36) NULL,
	[bs_id] [varchar](36) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[deadId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[identNum] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_bs_record]    Script Date: 04/28/2015 14:38:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_bs_record](
	[record_id] [varchar](36) NOT NULL,
	[create_date] [datetime] NOT NULL,
	[total_price] [float] NOT NULL,
	[length] [int] NULL,
	[overdue] [datetime] NULL,
	[donatType] [varchar](10) NOT NULL,
	[payed] [bit] NOT NULL,
	[permit] [bit] NOT NULL,
	[bs_id] [varchar](36) NOT NULL,
	[user_id] [varchar](36) NOT NULL,
	[enter_id] [varchar](36) NULL,
	[member_id] [varchar](36) NULL,
	[pay_id] [varchar](36) NULL,
PRIMARY KEY CLUSTERED 
(
	[record_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  ForeignKey [FK2420D2555A629144]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[role_module]  WITH CHECK ADD  CONSTRAINT [FK2420D2555A629144] FOREIGN KEY([role_id])
REFERENCES [dbo].[t_role] ([roleId])
GO
ALTER TABLE [dbo].[role_module] CHECK CONSTRAINT [FK2420D2555A629144]
GO
/****** Object:  ForeignKey [FK2420D255D2F29B04]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[role_module]  WITH CHECK ADD  CONSTRAINT [FK2420D255D2F29B04] FOREIGN KEY([module_id])
REFERENCES [dbo].[t_module] ([module_id])
GO
ALTER TABLE [dbo].[role_module] CHECK CONSTRAINT [FK2420D255D2F29B04]
GO
/****** Object:  ForeignKey [FK574A8F743C5FBDAF]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_bless_seat]  WITH CHECK ADD  CONSTRAINT [FK574A8F743C5FBDAF] FOREIGN KEY([shelf_id])
REFERENCES [dbo].[t_shelf] ([shelfId])
GO
ALTER TABLE [dbo].[t_bless_seat] CHECK CONSTRAINT [FK574A8F743C5FBDAF]
GO
/****** Object:  ForeignKey [FK574A8F74E2C3876F]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_bless_seat]  WITH CHECK ADD  CONSTRAINT [FK574A8F74E2C3876F] FOREIGN KEY([level_id])
REFERENCES [dbo].[t_level] ([levId])
GO
ALTER TABLE [dbo].[t_bless_seat] CHECK CONSTRAINT [FK574A8F74E2C3876F]
GO
/****** Object:  ForeignKey [FKF4F209F42A11C5E5]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_bs_record]  WITH CHECK ADD  CONSTRAINT [FKF4F209F42A11C5E5] FOREIGN KEY([member_id])
REFERENCES [dbo].[t_member] ([memberId])
GO
ALTER TABLE [dbo].[t_bs_record] CHECK CONSTRAINT [FKF4F209F42A11C5E5]
GO
/****** Object:  ForeignKey [FKF4F209F4A1DB771E]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_bs_record]  WITH CHECK ADD  CONSTRAINT [FKF4F209F4A1DB771E] FOREIGN KEY([bs_id])
REFERENCES [dbo].[t_bless_seat] ([bsId])
GO
ALTER TABLE [dbo].[t_bs_record] CHECK CONSTRAINT [FKF4F209F4A1DB771E]
GO
/****** Object:  ForeignKey [FKF4F209F4A53B742E]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_bs_record]  WITH CHECK ADD  CONSTRAINT [FKF4F209F4A53B742E] FOREIGN KEY([enter_id])
REFERENCES [dbo].[t_enterprise] ([enterId])
GO
ALTER TABLE [dbo].[t_bs_record] CHECK CONSTRAINT [FKF4F209F4A53B742E]
GO
/****** Object:  ForeignKey [FKF4F209F4EEEEDCE0]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_bs_record]  WITH CHECK ADD  CONSTRAINT [FKF4F209F4EEEEDCE0] FOREIGN KEY([pay_id])
REFERENCES [dbo].[t_pay_record] ([payRecId])
GO
ALTER TABLE [dbo].[t_bs_record] CHECK CONSTRAINT [FKF4F209F4EEEEDCE0]
GO
/****** Object:  ForeignKey [FKF4F209F4FF8D5524]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_bs_record]  WITH CHECK ADD  CONSTRAINT [FKF4F209F4FF8D5524] FOREIGN KEY([user_id])
REFERENCES [dbo].[t_user] ([userId])
GO
ALTER TABLE [dbo].[t_bs_record] CHECK CONSTRAINT [FKF4F209F4FF8D5524]
GO
/****** Object:  ForeignKey [FK63D9D23C57B70873]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_deader]  WITH CHECK ADD  CONSTRAINT [FK63D9D23C57B70873] FOREIGN KEY([adcard_id])
REFERENCES [dbo].[t_adovcater_card] ([cardId])
GO
ALTER TABLE [dbo].[t_deader] CHECK CONSTRAINT [FK63D9D23C57B70873]
GO
/****** Object:  ForeignKey [FK63D9D23C95D371F6]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_deader]  WITH CHECK ADD  CONSTRAINT [FK63D9D23C95D371F6] FOREIGN KEY([card_id])
REFERENCES [dbo].[t_adovcater_card] ([cardId])
GO
ALTER TABLE [dbo].[t_deader] CHECK CONSTRAINT [FK63D9D23C95D371F6]
GO
/****** Object:  ForeignKey [FK63D9D23CA1DB771E]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_deader]  WITH CHECK ADD  CONSTRAINT [FK63D9D23CA1DB771E] FOREIGN KEY([bs_id])
REFERENCES [dbo].[t_bless_seat] ([bsId])
GO
ALTER TABLE [dbo].[t_deader] CHECK CONSTRAINT [FK63D9D23CA1DB771E]
GO
/****** Object:  ForeignKey [FK40C28A4A2A11C5E5]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_member_card]  WITH CHECK ADD  CONSTRAINT [FK40C28A4A2A11C5E5] FOREIGN KEY([member_id])
REFERENCES [dbo].[t_member] ([memberId])
GO
ALTER TABLE [dbo].[t_member_card] CHECK CONSTRAINT [FK40C28A4A2A11C5E5]
GO
/****** Object:  ForeignKey [FK40C28A4AA53B742E]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_member_card]  WITH CHECK ADD  CONSTRAINT [FK40C28A4AA53B742E] FOREIGN KEY([enter_id])
REFERENCES [dbo].[t_enterprise] ([enterId])
GO
ALTER TABLE [dbo].[t_member_card] CHECK CONSTRAINT [FK40C28A4AA53B742E]
GO
/****** Object:  ForeignKey [FK73C3F89731BEEF]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_module]  WITH CHECK ADD  CONSTRAINT [FK73C3F89731BEEF] FOREIGN KEY([parsent])
REFERENCES [dbo].[t_module] ([module_id])
GO
ALTER TABLE [dbo].[t_module] CHECK CONSTRAINT [FK73C3F89731BEEF]
GO
/****** Object:  ForeignKey [FK36B51C73EEEEDCE0]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_pay_detail]  WITH CHECK ADD  CONSTRAINT [FK36B51C73EEEEDCE0] FOREIGN KEY([pay_id])
REFERENCES [dbo].[t_pay_record] ([payRecId])
GO
ALTER TABLE [dbo].[t_pay_detail] CHECK CONSTRAINT [FK36B51C73EEEEDCE0]
GO
/****** Object:  ForeignKey [FK4E9170732A11C5E5]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_pay_record]  WITH CHECK ADD  CONSTRAINT [FK4E9170732A11C5E5] FOREIGN KEY([member_id])
REFERENCES [dbo].[t_member] ([memberId])
GO
ALTER TABLE [dbo].[t_pay_record] CHECK CONSTRAINT [FK4E9170732A11C5E5]
GO
/****** Object:  ForeignKey [FK4E917073A53B742E]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_pay_record]  WITH CHECK ADD  CONSTRAINT [FK4E917073A53B742E] FOREIGN KEY([enter_id])
REFERENCES [dbo].[t_enterprise] ([enterId])
GO
ALTER TABLE [dbo].[t_pay_record] CHECK CONSTRAINT [FK4E917073A53B742E]
GO
/****** Object:  ForeignKey [FK4E917073FF8D5524]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_pay_record]  WITH CHECK ADD  CONSTRAINT [FK4E917073FF8D5524] FOREIGN KEY([user_id])
REFERENCES [dbo].[t_user] ([userId])
GO
ALTER TABLE [dbo].[t_pay_record] CHECK CONSTRAINT [FK4E917073FF8D5524]
GO
/****** Object:  ForeignKey [FK95A06D67C0E3C164]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_relation]  WITH CHECK ADD  CONSTRAINT [FK95A06D67C0E3C164] FOREIGN KEY([mem_memberId])
REFERENCES [dbo].[t_member] ([memberId])
GO
ALTER TABLE [dbo].[t_relation] CHECK CONSTRAINT [FK95A06D67C0E3C164]
GO
/****** Object:  ForeignKey [FKA0F49A9F5AC5BBC5]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_shelf]  WITH CHECK ADD  CONSTRAINT [FKA0F49A9F5AC5BBC5] FOREIGN KEY([area_id])
REFERENCES [dbo].[t_area] ([areaId])
GO
ALTER TABLE [dbo].[t_shelf] CHECK CONSTRAINT [FKA0F49A9F5AC5BBC5]
GO
/****** Object:  ForeignKey [FK8FAF43BF2A11C5E5]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_tablet_record]  WITH CHECK ADD  CONSTRAINT [FK8FAF43BF2A11C5E5] FOREIGN KEY([member_id])
REFERENCES [dbo].[t_member] ([memberId])
GO
ALTER TABLE [dbo].[t_tablet_record] CHECK CONSTRAINT [FK8FAF43BF2A11C5E5]
GO
/****** Object:  ForeignKey [FK8FAF43BF6F4DA265]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_tablet_record]  WITH CHECK ADD  CONSTRAINT [FK8FAF43BF6F4DA265] FOREIGN KEY([tablet_id])
REFERENCES [dbo].[t_tablet] ([tabletId])
GO
ALTER TABLE [dbo].[t_tablet_record] CHECK CONSTRAINT [FK8FAF43BF6F4DA265]
GO
/****** Object:  ForeignKey [FK8FAF43BFA53B742E]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_tablet_record]  WITH CHECK ADD  CONSTRAINT [FK8FAF43BFA53B742E] FOREIGN KEY([enter_id])
REFERENCES [dbo].[t_enterprise] ([enterId])
GO
ALTER TABLE [dbo].[t_tablet_record] CHECK CONSTRAINT [FK8FAF43BFA53B742E]
GO
/****** Object:  ForeignKey [FK8FAF43BFEEEEDCE0]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_tablet_record]  WITH CHECK ADD  CONSTRAINT [FK8FAF43BFEEEEDCE0] FOREIGN KEY([pay_id])
REFERENCES [dbo].[t_pay_record] ([payRecId])
GO
ALTER TABLE [dbo].[t_tablet_record] CHECK CONSTRAINT [FK8FAF43BFEEEEDCE0]
GO
/****** Object:  ForeignKey [FK8FAF43BFFF8D5524]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[t_tablet_record]  WITH CHECK ADD  CONSTRAINT [FK8FAF43BFFF8D5524] FOREIGN KEY([user_id])
REFERENCES [dbo].[t_user] ([userId])
GO
ALTER TABLE [dbo].[t_tablet_record] CHECK CONSTRAINT [FK8FAF43BFFF8D5524]
GO
/****** Object:  ForeignKey [FK143BF46A5A629144]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[user_role]  WITH CHECK ADD  CONSTRAINT [FK143BF46A5A629144] FOREIGN KEY([role_id])
REFERENCES [dbo].[t_role] ([roleId])
GO
ALTER TABLE [dbo].[user_role] CHECK CONSTRAINT [FK143BF46A5A629144]
GO
/****** Object:  ForeignKey [FK143BF46AFF8D5524]    Script Date: 04/28/2015 14:38:13 ******/
ALTER TABLE [dbo].[user_role]  WITH CHECK ADD  CONSTRAINT [FK143BF46AFF8D5524] FOREIGN KEY([user_id])
REFERENCES [dbo].[t_user] ([userId])
GO
ALTER TABLE [dbo].[user_role] CHECK CONSTRAINT [FK143BF46AFF8D5524]
GO
