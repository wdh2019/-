1.1 使用openMP对C语言代码进行改造
所需库函数：omp.h  stdio.h
运行方法：
编译：gcc test.c -fopenmp -o test (记得-fopenmp，它提供了openmp运行环境)
运行(windows)：test.exe
运行(linux)：./test

1.2.1 Java实现异步IO
所需库函数：jdk 11(本文作者使用jdk11，jdk11以下的jdk版本请自行尝试)
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Future;
import java.nio.charset.Charset;
运行方法：
1. 使用intellij IDEA打开src/asyncIO.java并运行（如果要测其他文件，更改asyncRead函数中的文件路径，因为intellij的项目根目录在src所以别忘了路径前面跟src/）
2. 如果想使用cmd运行src/asyncIO.java文件，需进行如下步骤：
  2.1 将代码第11行asyncRead函数中的文件路径改成"./passage.txt"（如果要测其他文件也改成相对路径形式，如"./passage1.txt"）
  2.2 javac -encoding UTF-8 asyncIO.java（原编码为gbk，有部分注释会导致编码错误）
  2.3 java asyncIO

1.2.2JavaScript实现异步IO
nodejs-solution:
所需库函数：都给你安装在node_modules里了，安装了node.js，且别删了文件夹就行
运行方法：打开cmd输入npm start或node asyncIO.js

webworker-solution:
所需库函数：同上&一个支持web worker(HTML5)的浏览器&vscode编辑器
运行方法：使用vscode打开index.html，使用vscode的插件live server将其部署到本地，在适合的浏览器上运行。

1.3基于c++实现异步IO
所需库函数：iostream  time.h  fstream.h  omp.h
运行方法：
编译：g++ asyncIO.cpp -fopenmp -o asyncIO (记得-fopenmp，它提供了openmp运行环境)
运行(windows)：asyncIO.exe
运行(linux)：./asyncIO