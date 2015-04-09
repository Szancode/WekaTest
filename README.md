# WekaTest
some error
使用说明
Segmenter.java 将训练集所在文件夹中的txt文件分词并存入新的文件夹（地址在程序中输入）

TextCategorizationTest.java是将分好词的训练集文件夹转换成weka可用的arff文件

testtxttoarff.java 将一篇txt文档转换为可用的arff文档string类型 不能直接被分类器使用

Stringtext.java 将txt文档转换后的arff文件转换成分类器可用的arff格式。

TreeTest.java 调用weka的分类器

每个.java都是单独执行没有整合。
