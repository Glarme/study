# Git 全局设置
添加--global是全局设置，单个仓库的本地设置在.git/conf配置
``` shell

git config --global user.name "Your Name"
git config --global user.email "youreamil@domain"

# 设置别名
git config --global alias.st status
git config --global alias.co checkout
git config --global alias.ci commit
git config --global alias.br branch

# 可以把暂存区的修改撤销掉（unstage)
git config --global alias.unstage 'reset HEAD'
# 查看最后一次的记录
git config --global alias.last 'log -1'

git config --global alias.lg "log --color --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit"
```

# 生成SSH Key
``` shell
#生成rsa加密算法的ssh key，并指定密钥长度为4096
ssh-keygen -t rsa -C "youremail@example.com" -b 4096
ssh-keygen 用法：
-b：指定密钥长度； 
-e：读取openssh的私钥或者公钥文件； 
-C：添加注释； 
-f：指定用来保存密钥的文件名； 
-i：读取未加密的ssh-v2兼容的私钥/公钥文件，然后在标准输出设备上显示openssh兼容的私钥/公钥； 
-l：显示公钥文件的指纹数据； 
-N：提供一个新密语； 
-P：提供（旧）密语；
-q：静默模式； 
-t：指定要创建的密钥类型。
```

# 从GitLab已创建的Project构建
```  shell
git clone REMOTE_GIT_PATH/study.git
cd study
touch README.md
# 编辑 the README.md
# 添加 the README.md 到暂存区
git add README.md
# 本地提交
git commit -m 'add README.md'
# 推送同步到远程服务器
git push -u origin master
```

# 从本地构建
``` shell
# 创建目录
mkdir git_folder
# 初始化仓库
git init
# 关联远程，远程仓库必须存在
git remote add origin REMOTE_GIT_PATH/study.git
# 添加目录下所有文件
git add .
git commit -m "initial commit"
git push -u origin master
```


# 关联已存在仓库
``` shell
cd git_folder
# 关联远程，远程仓库必须存在
git remote add origin REMOTE_GIT_PATH/study.git
git push -u origin --all
git push -u origin --tags
```

#管理修改
``` shell
# 查看git状态，可查看工作区和暂存区状态，包括新增，修改等
git status

# 将工作区的修改添加到暂存区
git add

# 将暂存区变更提交
git commit 

# 从版本库检出最新版本，即放弃当前工作区修改
git checkout -- fileName

# 查看提交记录， --pretty=oneline 简略信息 --graph 简图 --abbrev-commit 提交者
git log
# 查看命令记录
git reflog

# 撤销暂存区修改
git reset HEAD fileName
# HEAD表示当前版本，HEAD^为上一个版本，HEAD^^上上一版本，依次同理，也可写作HEAD~100,即回退100个版本
git reset --hard HEAD^
# 回退到指定commitId版本
git reset --hard commitId

# 添加新的分支,常用分支有master,dev,bug,feature
git branch name
# 删除分支，有修改未被合并的分支会提醒，可使用-D强制删除
git branch -d branchName
# 关联本地分支与远程分支
git branch --set-upstream dev origin/dev
# 检出到指定分支
git checkout -- branckName

# 创建分支，并检出
git checkout -b branchName

# 查看工作区和版本库最新版区别
git diff HEAD -- <filename...>

# 合并分支，指定分支合并到当前分支,如果可能，Git会用Fast forward模式，但这种模式下，删除分支后，会丢掉分支信息
git merge branchName

# 如果要强制禁用Fast forward模式，Git就会在merge时生成一个新的commit，这样，从分支历史上就可以看出分支信息。合并时会创建commit,所以携带-m
git merge --no-ff -m 'merge branch message'  branchName

# 可以把当前工作现场“储藏”起来，等以后恢复现场后继续工作
git stash

# 列出储存的工作空间信息
git stash list

# 回复工作空间信息，不删除储存的内容，多个的时候使用git stash apply stash@{0}，序号可在list查看
git stash apply

# 删除储存空间信息
git stash drop

# 以栈的形式弹出最顶层，并删除
git stash pop
```

# 远程版本库多人协作
``` shell
# 查看远程库信息 -v查看详细信息
git remote

# 推送分支，指定本地分支，如master
# 优先push，如果存在冲突，pull到本地合并，解决冲突
git push origin branchName

# 克隆远程仓库到本地，默认master分支
git clone REMOTE_GIT_PATH/study.git

# 在已经clone到本地的基础上检出dev分支到本地dev分支
git checkout -b dev origin/dev

# 从远程版本库抓取最新内容
git pull
```

# 标签(Tags)
tag本质是指向commitId的指针，commitId是一串十六进制字符串，不便于记忆
``` shell
# 查看所有标签
git tag

# 先切换到需要标签的分支，然后设置标签,默认标签指向HEAD，即当前版本
git tag tagName

# 根据commitId 设置标签，标签指向commitId时版本
git tag tagName commitId

# 添加标签说明,可用-s参数用私钥q签名一个标签
git tag -a tagName -m 'add tag message' commitId
# 查看标签信息
git show tagName

# 删除标签
git tag -d tagName

# 远程删除标签
git push origin :refs/tags/tagName
# 推送标签到远程
git push origin tagName

# 推送所有未推送的标签
git push origin --tags
```