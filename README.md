# JFinal-ext2

#####v2.0.0更新内容
1. 基于 JFinal2.1;
2. 集成了 JFinal 牛逼的 Genretor, 让你自动生成 model 更Easy:);
3. 修改了配置文件格式,加入了很多的说明;
4. 扩展DruidPlugin做了一个DruidEncryptPlugin,在配置文件中使用加密的数据库密码;
5. 使用 maven 管理项目;

#####配置说明
```shell
#--------------------------------------------------------------------#
#  database　Config
# 1. db.active:ture, use db;是否开启数据库;
# 2. db.dscnt: db datasource count;数据源数量;
# 3. db.cfgname*: configname;数据配置 name,*为序号;
# 4. db.url*: db url;数据库的 url,*为序号;
# 5. db.user: db username;数据库用户名;
# 6. db.password: db password;数据库密码,已加密
#	use `java -cp druid-xx.jar com.alibaba.druid.filter.config.ConfigTools your_password`
#	generate your encrypt password; 使用com.alibaba.druid.filter.config.ConfigTools获得加密密码;
# 7. db.initsize: db pool init size;连接池初始化大小;
# 8. db.maxactive: db pool maxactive;连接池最大连接数;
# 9. db.showsql: ture, show execute sql;是否显示 sql;
#--------------------------------------------------------------------#
db.active = false
db.dscnt = 1
db.cfgname1 = config1
db.url1 = testing_host/db
db.user = 
db.password = lCzd9geWAuAuJtLhpaG/J+d28H8KiMFAWopxXkYpMNdUai6Xe/LsPqMQeg5MIrmvtMa+hzycdRhWs29ZUPU1IQ==
db.initsize = 6
db.maxactive = 100
db.showsql = true
#--------------------------------------------------------------------#
# Generator Config
# 1. ge.run: true, generate the model and basemmodels;是否生成 models;
# 2. ge.base.model.outdir: the basemodel output dir path;basemodel输出目录;
# 3. ge.base.model.package: the basemodel package;basemodel 包名;
# 4. ge.model.outdir: the model output dir path;model输出目录;
# 5. ge.model.package: the model package;model包名;
#--------------------------------------------------------------------#
ge.run=true
ge.base.model.outdir=
ge.base.model.package=
ge.model.outdir=
ge.model.package=
#--------------------------------------------------------------------#
## App Config
# 1. app.dev: true, the app is debug mode;是否为 debug 模式;
# 2. app.upload.basedir: upload file save base dir;上传文件存放的基目录;
# 3. app.post: ture, use Http Post method;
# 4. app.name: app's name;当前 app 的名字;
#--------------------------------------------------------------------#
app.dev = true
app.upload.basedir = /var/uploads
app.post = true
app.name = 
```


基于JFinal 2.0加入一些kit，它们有

1. 扩展JFinalConfig=> JFinalConfigExt

	1.1 给每一个app设置一个name；

	1.2 从配置文件中获取文件的保存路径；

	1.3 获取devmode；

	1.4 打包DruidPlugin和ActiveRecordPlugin；

	以上让你的config更加轻便

2. 加入ActionExtentionHandler
	更方面的伪静态处理

3. 加入 NotFoundActionInterceptor 当找不到对应的 action 时，fire 404

4. com.jfinal.ext2.kit

	3.1 DateTimeKit;

	3.2 DDLKit;

	...

5. com.jfinal.ext2.validate.ValidatorExt

	默认开启短路，校验失败403

6. 加入多个文件上传的FileRenamePolicy
	
	6.1 CustomNameFileRenamePolicy 自定义文件名称
	6.2 CustomParentDirFileRenamePolicy 自定义上级目录名称
	6.3 DateRandomFileRenamePolicy 按照时间分割目录
	6.4 RandomFileRenamePolicy 随机文件名称


Demo ： [http://git.oschina.net/brucezcq/JFinal-Ext2-Demo](http://git.oschina.net/brucezcq/JFinal-Ext2-Demo)