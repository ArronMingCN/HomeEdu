项目介绍：一个家教平台的实现，主要三个模块分别是登陆注册模块、教员模块，学生/家长模块。
实现：前端采用了css+html的设计。
           后端采用了spring+mysql的实现。java代码采用了标准的三层结构：Controller、Service、DAO实现各种逻辑交互。数据库采用了alibaba druid连接池做连接管理，dbutils做数据库操作。
         整个项目结构清晰，简洁有效。


网站配置过程：
     该网站不需要过多的配置，主要需要两个方面：
      1、在mysql中导入放在resource文件夹中的homeedu.sql文件。
      2、在spring文件夹中的config.properties 文件中配置自己数据库的路径，登录名，密码
   然后在地址栏中敲       主机地址：端口号/HomeEdu          即可访问网站。不同浏览器可能前端显示有差异，请谅解。
     
   2017/6/21


