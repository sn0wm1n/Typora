## Git三层

##### Git Repository（git仓库）    
##### 暂存区  
##### 工作区（working Directory）


mkdir 文件名   创建文件  
## git仓库初始化（让git知道，他需要来管理这个目录）
git init  
执行后会在目录下创建.git隐藏目录，这个目录是git所创建的不能删除，也不能**随意**更改其中的内容  

git add 文件名  --添加到缓存区  
**可以同时添加多个文件**
git add 文件名 文件名 文件名.....
git add.
git status  查看当前状态  
git commit-m "注释内容"  提交描述   把当前缓存区的文件都提交上去  

## 一般就是用git add    git commit-m "注释内容" 来上传文件
git log   更详细  
git --pretty==oneline  更方便查看  
git reset --hard 回退到指定的提交编号  
回到过去后要想再回到之前最新的版本号就去查看历史操作  
git reflog

## 两种使用方式？
### 1基于http协议
a，使用clone指令克隆线上仓库到本地  
git clone 线上仓库地址  
git add  
git commit -m “”  
git push    

git pull