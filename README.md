# workspaceTest
这是一个workspace功能的小测试

## 计算器项目
这个项目实现了一个基本的计算器，具有以下算术运算功能：
- 加法
- 减法
- 乘法
- 除法

## 部署步骤

### 安装依赖
在项目根目录下运行以下命令来安装所需的依赖：
```
mvn install
```

### 编译项目
在项目根目录下运行以下命令来编译项目：
```
mvn compile
```

### 运行项目
在项目根目录下运行以下命令来运行项目：
```
mvn exec:java -Dexec.mainClass="com.example.Calculator"
```

## 使用UI
这个项目提供了一个简单的UI界面，用户可以输入任意数字并进行加减乘除运算。

### 运行UI
在项目根目录下运行以下命令来启动UI：
```
java -cp target/classes com.example.Main
```
