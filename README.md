# simulation-project
虚拟仿真实验项目分布式框架
=======
### 虚拟仿真实验项目开发文档

#### 数据库设计

##### user 用户表

| 字段     | 类型      | 长度 | 说明                 | 是否为空 |
| -------- | --------- | ---- | -------------------- | -------- |
| id       | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| username | varchar   | 16   | 用户名               | 不为空   |
| password | varchar   | 16   | 密码，长度为16位     | 不为空   |
| salt     | varchar   | 16   | md5加密的盐          | 不为空   |
| phone    | varchar   | 11   | 用户的手机号码       | 不为空   |
| date     | timestamp | 0    | 时间戳               | 不为空   |

##### role 角色表

| 字段        | 类型      | 长度 | 说明                 | 是否为空 |
| ----------- | --------- | ---- | -------------------- | -------- |
| id          | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| roleName    | varchar   | 10   | 角色名称             | 不为空   |
| description | varchar   | 25   | 角色描述             | 不为空   |
| date        | timestamp | 0    | 时间戳               | 不为空   |

##### permission 权限表

| 字段           | 类型      | 长度 | 说明                 | 是否为空 |
| -------------- | --------- | ---- | -------------------- | -------- |
| id             | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| permissionName | varchar   | 16   | 权限名称             | 不为空   |
| description    | varchar   | 25   | 权限描述             | 不为空   |
| date           | timestamp | 0    | 时间戳               | 不为空   |

##### userrole 用户角色关系表

| 字段   | 类型      | 长度 | 说明                 | 是否为空 |
| ------ | --------- | ---- | -------------------- | -------- |
| id     | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| roleId | varchar   | 32   | 角色id，uuid         | 不为空   |
| userId | varchar   | 32   | 用户id，uuid         | 不为空   |
| date   | timestamp | 0    | 时间戳               | 不为空   |

##### rolepermission 角色权限关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| roleId       | varchar   | 32   | 角色id，uuid         | 不为空   |
| permissionId | varchar   | 32   | 权限id，uuid         | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### student_info 学生信息表

| 字段         | 类型      | 长度 | 说明                        | 是否为空 |
| ------------ | --------- | ---- | --------------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增        | 不为空   |
| picId        | varchar   | 32   | 头像图片id                  | 可为空   |
| username     | varchar   | 16   | 用户名                      | 不为空   |
| email        | varchar   | 25   | 邮箱                        | 可为空   |
| phone        | varchar   | 11   | 手机号                      | 不为空   |
| name         | varchar   | 5    | 真实姓名                    | 可为空   |
| sex          | int       | 1    | 性别，0为男，1为女，2为其他 | 可为空   |
| birth        | date      | 0    | 生日                        | 可为空   |
| PID          | varchar   | 18   | 身份证                      | 可为空   |
| school       | varchar   | 16   | 学校名称                    | 可为空   |
| education    | varchar   | 10   | 学历                        | 可为空   |
| introduction | varchar   | 255  | 个人简介                    | 可为空   |
| date         | timestamp | 0    | 时间戳                      | 不为空   |

#####  teacher_info 教师信息表

| 字段         | 类型      | 长度 | 说明                        | 是否为空 |
| ------------ | --------- | ---- | --------------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增        | 不为空   |
| number       | varchar   | 64   | 教职工号                    | 不为空   |
| picId        | varchar   | 32   | 头像图片id                  | 可为空   |
| username     | varchar   | 16   | 用户名                      | 不为空   |
| email        | varchar   | 25   | 邮箱                        | 可为空   |
| phone        | varchar   | 11   | 手机号                      | 不为空   |
| name         | varchar   | 5    | 真实姓名                    | 可为空   |
| sex          | int       | 1    | 性别，0为男，1为女，2为其他 | 可为空   |
| birth        | date      | 0    | 生日                        | 可为空   |
| PID          | varchar   | 18   | 身份证                      | 可为空   |
| school       | varchar   | 16   | 学校名称                    | 可为空   |
| education    | varchar   | 10   | 学历                        | 可为空   |
| field        | varchar   | 25   | 擅长的领域                  | 可为空   |
| loService    | int       | 2    | 工龄                        | 不为空   |
| introduction | varchar   | 255  | 个人简介                    | 可为空   |
| achievement  | varchar   | 255  | 个人成就                    | 可为空   |
| date         | timestamp | 0    | 时间戳                      | 不为空   |

##### user_Info	用户信息关系表

| 字段   | 类型      | 长度 | 说明                     | 是否为空 |
| ------ | --------- | ---- | ------------------------ | -------- |
| id     | varchar   | 32   | 主键id，uuid，不自增     | 不为空   |
| userId | varchar   | 32   | 用户id，uuid             | 不为空   |
| infoId | varchar   | 32   | 用户信息id，uuid         | 不为空   |
| type   | int       | 1    | 角色id，0为学生，1为教师 | 不为空   |
| date   | timestamp | 0    | 时间戳                   | 不为空   |

##### class_info 班级信息表

| 字段       | 类型      | 长度 | 说明                 | 是否为空 |
| ---------- | --------- | ---- | -------------------- | -------- |
| id         | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| className  | varchar   | 16   | 班级名称             | 不为空   |
| number     | int       | 3    | 班级总人数           | 不为空   |
| grade      | varchar   | 10   | 年级                 | 不为空   |
| department | varchar   | 16   | 所在系               | 可为空   |
| date       | timestamp | 0    | 时间戳               | 不为空   |

##### user_class 用户班级关系表

| 字段    | 类型      | 长度 | 说明                 | 是否为空 |
| ------- | --------- | ---- | -------------------- | -------- |
| id      | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| userId  | varchar   | 32   | 用户id，uuid         | 不为空   |
| classId | varchar   | 32   | 班级id，uuid         | 不为空   |
| date    | timestamp | 0    | 时间戳               | 不为空   |

##### school_info 学校信息表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| schoolName   | varchar   | 16   | 学校名称             | 不为空   |
| address      | varchar   | 45   | 学校地址             | 可为空   |
| label        | varchar   | 16   | 学校标签             | 可为空   |
| introduction | varchar   | 255  | 学校简介             | 可为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### user_school 用户学校关系表

| 字段     | 类型      | 长度 | 说明                 | 是否为空 |
| -------- | --------- | ---- | -------------------- | -------- |
| id       | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| userId   | varchar   | 32   | 用户id，uuid         | 不为空   |
| schoolId | varchar   | 32   | 学校id，uuid         | 不为空   |
| date     | timestamp | 0    | 时间戳               | 不为空   |

##### class_school 班级学校关系表

| 字段     | 类型      | 长度 | 说明                 | 是否为空 |
| -------- | --------- | ---- | -------------------- | -------- |
| id       | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| classId  | varchar   | 32   | 班级id，uuid         | 不为空   |
| schoolId | varchar   | 32   | 学校id，uuid         | 不为空   |
| date     | timestamp | 0    | 时间戳               | 不为空   |

##### picture 图片表

| 字段        | 类型      | 长度 | 说明                 | 是否为空 |
| ----------- | --------- | ---- | -------------------- | -------- |
| id          | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| initialName | varchar   | 45   | 图片原始名称         | 不为空   |
| uuidName    | varchar   | 32   | 图片新生成的uuid名称 | 不为空   |
| type        | varchar   | 5    | 图片类型             | 不为空   |
| address     | varchar   | 255  | 图片所在的地址       | 不为空   |
| date        | timestamp | 0    | 时间戳               | 不为空   |

##### file 文件表

| 字段        | 类型      | 长度 | 说明                 | 是否为空 |
| ----------- | --------- | ---- | -------------------- | -------- |
| id          | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| initialName | varchar   | 45   | 文件原始名称         | 不为空   |
| uuidName    | varchar   | 32   | 文件新的uuid名称     | 不为空   |
| type        | varchar   | 5    | 文件类型             | 不为空   |
| address     | varchar   | 255  | 文件所在的地址       | 不为空   |
| date        | timestamp | 0    | 时间戳               | 不为空   |

##### comment 评论表

| 字段       | 类型      | 长度 | 说明                 | 是否为空 |
| ---------- | --------- | ---- | -------------------- | -------- |
| id         | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| moduleId   | varchar   | 32   | 模块id               | 不为空   |
| authorId   | varchar   | 32   | 被评论者用户id       | 不为空   |
| commentId  | varchar   | 32   | 评论者用户id         | 不为空   |
| floor      | int       | 1    | 评论的层级           | 不为空   |
| context    | text      | 0    | 评论的内容           | 不为空   |
| likeNumber | int       | 11   | 点赞量               | 不为空   |
| flag       | varchar   | 32   | 评论的标识符         | 不为空   |
| date       | timestamp | 0    | 时间戳               | 不为空   |

##### notice 通知表

| 字段     | 类型      | 长度 | 说明                       | 是否为空 |
| -------- | --------- | ---- | -------------------------- | -------- |
| id       | varchar   | 32   | 主键id，uuid，不自增       | 不为空   |
| title    | varchar   | 45   | 通知的标题                 | 不为空   |
| context  | text      | 0    | 通知的内容                 | 不为空   |
| userId   | varchar   | 32   | 被通知用户id               | 不为空   |
| byUserId | varchar   | 32   | 通知用户id                 | 不为空   |
| hasRead  | int       | 1    | 是否已读，0为已读，1为未读 | 不为空   |
| date     | timestamp | 0    | 时间戳                     | 不为空   |

##### notice_file 通知文件关系表

| 字段     | 类型      | 长度 | 说明                 | 是否为空 |
| -------- | --------- | ---- | -------------------- | -------- |
| id       | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| noticeId | varchar   | 32   | 通知id               | 不为空   |
| fileId   | varchar   | 32   | 文件id               | 不为空   |
| date     | timestamp | 0    | 时间戳               | 不为空   |

##### curriculum 课程信息表

| 字段            | 类型      | 长度 | 说明                         | 是否为空 |
| --------------- | --------- | ---- | ---------------------------- | -------- |
| id              | varchar   | 32   | 主键id，uuid，不自增         | 不为空   |
| experimentName  | varchar   | 25   | 实验名称                     | 不为空   |
| teacherName     | varchar   | 5    | 教师名称                     | 不为空   |
| whichDay        | varchar   | 10   | 周几                         | 不为空   |
| address         | varchar   | 25   | 地点                         | 不为空   |
| startWeek       | int       | 2    | 开始周                       | 不为空   |
| endWeek         | int       | 2    | 结束周                       | 不为空   |
| sdwFlag         | int       | 1    | 单双周标记，0为单周，1为双周 | 不为空   |
| whichCurriculum | varchar   | 16   | 第几节课                     | 不为空   |
| sectionNumber   | int       | 2    | 节数                         | 不为空   |
| semester        | varchar   | 25   | 学期                         | 不为空   |
| date            | timestamp | 0    | 时间                         | 不为空   |

##### class_curriculum 班级课程关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| classId      | varchar   | 32   | 班级id，uuid         | 不为空   |
| curriculumId | varchar   | 32   | 课程id，uuid         | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### group 分组表

| 字段   | 类型      | 长度 | 说明                 | 是否为空 |
| ------ | --------- | ---- | -------------------- | -------- |
| id     | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| name   | varchar   | 16   | 分组名称             | 不为空   |
| number | int       | 3    | 分组人数             | 不为空   |
| date   | timestamp | 0    | 时间戳               | 不为空   |

##### group_user 用户分组关系表

| 字段    | 类型      | 长度 | 说明                 | 是否为空 |
| ------- | --------- | ---- | -------------------- | -------- |
| id      | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| groupId | varchar   | 32   | 分组id，uuid         | 不为空   |
| userId  | varchar   | 32   | 用户id，uuid         | 不为空   |
| date    | timestamp | 0    | 时间戳               | 不为空   |

##### experiment 实验表

| 字段    | 类型      | 长度 | 说明                 | 是否为空 |
| ------- | --------- | ---- | -------------------- | -------- |
| id      | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| name    | varchar   | 25   | 实验名称             | 不为空   |
| coverId | varchar   | 32   | 实验的封面图片id     | 可为空   |
| context | text      | 0    | 实验的简介内容       | 不为空   |
| date    | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_group 实验分组关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| experimentId | varchar   | 32   | 实验id，uuid         | 不为空   |
| groupId      | varchar   | 32   | 分组id，uuid         | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### class_group 班级分组关系表

| 字段    | 类型      | 长度 | 说明                 | 是否为空 |
| ------- | --------- | ---- | -------------------- | -------- |
| id      | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| classId | varchar   | 32   | 班级id，uuid         | 不为空   |
| groupId | varchar   | 32   | 分组id，uuid         | 不为空   |
| date    | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_statistics 实验统计表

| 字段        | 类型      | 长度 | 说明                 | 是否为空 |
| ----------- | --------- | ---- | -------------------- | -------- |
| id          | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| totalNumber | int       | 11   | 实验学习的总人数     | 不为空   |
| difficult   | varchar   | 5    | 实验的难易程度       | 不为空   |
| avgComplete | int       | 3    | 实验的平均完成情况   | 不为空   |
| avgGrade    | int       | 3    | 实验的平均成绩       | 不为空   |
| score       | int       | 3    | 实验的评分信息       | 不为空   |
| date        | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_experiment_statistics 实验统计信息关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| experimentId | varchar   | 32   | 实验id，uuid         | 不为空   |
| statisticsId | varchar   | 32   | 实验统计信息id，uuid | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_grade 实验成绩表

| 字段    | 类型      | 长度 | 说明                               | 是否为空 |
| ------- | --------- | ---- | ---------------------------------- | -------- |
| id      | varchar   | 32   | 主键id，uuid，不自增               | 不为空   |
| score   | int       | 3    | 实验成绩                           | 不为空   |
| comment | varchar   | 45   | 教师评语                           | 不为空   |
| status  | int       | 1    | 实验完成状态，0为已完成，1为未完成 | 不为空   |
| date    | timestamp | 0    | 时间戳                             | 不为空   |

##### experiment_user_grade 用户实验成绩关系表

| 字段              | 类型      | 长度 | 说明                 | 是否为空 |
| ----------------- | --------- | ---- | -------------------- | -------- |
| id                | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| experimentId      | varchar   | 32   | 实验id，uuid         | 不为空   |
| userId            | varchar   | 32   | 用户id，uuid         | 不为空   |
| experimentGradeId | varchar   | 32   | 实验成绩id，uuid     | 不为空   |
| date              | timestamp | 0    | 时间戳               | 不为空   |

##### type 类型表

| 字段        | 类型      | 长度 | 说明                 | 是否为空 |
| ----------- | --------- | ---- | -------------------- | -------- |
| id          | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| name        | varchar   | 25   | 类型名称             | 不为空   |
| description | varchar   | 255  | 类型描述             | 不为空   |
| date        | timestamp | 0    | 时间戳               | 不为空   |

##### type_experimentType 一级二级实验类型关系表

| 字段             | 类型      | 长度 | 说明                 | 是否为空 |
| ---------------- | --------- | ---- | -------------------- | -------- |
| id               | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| typeId           | varchar   | 32   | 一级id，uuid         | 不为空   |
| experimentTypeId | varchar   | 32   | 实验类型id，uuid     | 不为空   |
| date             | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_type 实验类型表

| 字段        | 类型      | 长度 | 说明                 | 是否为空 |
| ----------- | --------- | ---- | -------------------- | -------- |
| id          | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| name        | varchar   | 25   | 类型的名称           | 不为空   |
| description | varchar   | 255  | 类型的描述           | 可为空   |
| date        | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_experimentType 实验类型关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| experimentId | varchar   | 32   | 实验id，uuid         | 不为空   |
| typeId       | varchar   | 32   | 类型Id               | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_school 学校实验关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| experimentId | varchar   | 32   | 实验id，uuid         | 不为空   |
| schoolId     | varchar   | 32   | 学校id，uuid         | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_user 实验用户关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| experimentId | varchar   | 32   | 实验id，uuid         | 不为空   |
| userId       | varchar   | 32   | 用户id，uuid         | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_class 实验班级关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| experimentId | varchar   | 32   | 实验id，uuid         | 不为空   |
| classId      | varchar   | 32   | 班级id，uuid         | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_file 实验文件关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| experimentId | varchar   | 32   | 实验id，uuid         | 不为空   |
| fileId       | varchar   | 32   | 文件id，uuid         | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_comment 实验评论关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| experimentId | varchar   | 32   | 实验id，uuid         | 不为空   |
| commentId    | varchar   | 32   | 评论id，uuid         | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### grade 年级表

| 字段  | 类型      | 长度 | 说明                 | 是否为空 |
| ----- | --------- | ---- | -------------------- | -------- |
| id    | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| grade | varchar   | 16   | 年级                 | 不为空   |
| total | int       | 3    | 班级总数             | 不为空   |
| date  | timestamp | 0    | 时间戳               | 不为空   |

##### grade_class 年级班级关系表

| 字段    | 类型      | 长度 | 说明                 | 是否为空 |
| ------- | --------- | ---- | -------------------- | -------- |
| id      | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| gradeId | varchar   | 32   | 年级id，uuid         | 不为空   |
| classId | varchar   | 32   | 班级id，uuid         | 不为空   |
| date    | timestamp | 0    | 时间戳               | 不为空   |

##### experiment_grades 实验年级关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| experimentId | varchar   | 32   | 实验id，uuid         | 不为空   |
| gradeId      | varchar   | 32   | 年级id，uuid         | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### choice 选项表

| 字段    | 类型      | 长度 | 说明                 | 是否为空 |
| ------- | --------- | ---- | -------------------- | -------- |
| id      | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| option  | varchar   | 1    | 选项                 | 不为空   |
| context | varchar   | 255  | 选项内容             | 不为空   |
| date    | timestamp | 0    | 时间戳               | 不为空   |

##### choiceQuestion 选择题表

| 字段          | 类型      | 长度 | 说明                 | 是否为空 |
| ------------- | --------- | ---- | -------------------- | -------- |
| id            | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| topic         | varchar   | 45   | 题目                 | 不为空   |
| optionNumber  | int       | 1    | 选项数量             | 不为空   |
| correctOption | varchar   | 16   | 正确的选项           | 不为空   |
| correctAnswer | varchar   | 1000 | 正确的答案           | 不为空   |
| date          | timestamp | 0    | 时间戳               | 不为空   |

##### choice_choiceQuestion 选择题关系表

| 字段       | 类型      | 长度 | 说明                 | 是否为空 |
| ---------- | --------- | ---- | -------------------- | -------- |
| id         | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| questionId | varchar   | 32   | 选择题id，uuid       | 不为空   |
| choiceId   | varchar   | 32   | 选项id，uuid         | 不为空   |
| date       | timestamp | 0    | 时间戳               | 不为空   |

##### answerQuestion 简答题表

| 字段          | 类型      | 长度 | 说明                 | 是否为空 |
| ------------- | --------- | ---- | -------------------- | -------- |
| id            | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| topic         | text      | 0    | 题目                 | 不为空   |
| correctAnswer | text      | 0    | 正确答案             | 不为空   |
| date          | timestamp | 0    | 时间戳               | 不为空   |

##### tfQuestion 判断题表

| 字段          | 类型      | 长度 | 说明                   | 是否为空 |
| ------------- | --------- | ---- | ---------------------- | -------- |
| id            | varchar   | 32   | 主键id，uuid，不自增   | 不为空   |
| topic         | varchar   | 45   | 题目                   | 不为空   |
| correctAnswer | int       | 1    | 正确答案，0为对，1为错 | 不为空   |
| date          | timestamp | 0    | 时间戳                 | 不为空   |

##### assignment 作业表

| 字段         | 类型      | 长度 | 说明                               | 是否为空 |
| ------------ | --------- | ---- | ---------------------------------- | -------- |
| id           | varchar   | 25   | 主键id，uuid，不自增               | 不为空   |
| name         | varchar   | 45   | 作业名称                           | 不为空   |
| number       | int       | 3    | 作业题目数量                       | 不为空   |
| choiceNumber | int       | 3    | 选择题数量                         | 不为空   |
| choiceScore  | int       | 3    | 选择题每题分数                     | 不为空   |
| answerNumber | int       | 3    | 简答题数量                         | 不为空   |
| answerScore  | int       | 3    | 简答题每题分数                     | 不为空   |
| tfNumber     | int       | 3    | 判断题题目数量                     | 不为空   |
| tfScore      | int       | 3    | 判断题题目每题分数                 | 不为空   |
| totalScore   | int       | 3    | 作业总分数                         | 不为空   |
| startTime    | date      | 0    | 作业开始时间                       | 不为空   |
| endTime      | date      | 0    | 作业结束时间                       | 不为空   |
| status       | int       | 1    | 作业当前状态，0为可提交，1为已结束 | 不为空   |
| date         | timestamp | 0    | 时间戳                             | 不为空   |

##### assignment_question 作业题目关系表

| 字段         | 类型      | 长度 | 说明                                      | 是否为空 |
| ------------ | --------- | ---- | ----------------------------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增                      | 不为空   |
| assignmentId | varchar   | 32   | 作业id，uuid                              | 不为空   |
| questionId   | varchar   | 32   | 问题Id，uuid                              | 不为空   |
| questionType | int       | 1    | 问题类型，0为选择题，1为简答题，2为判断题 | 不为空   |
| date         | timestamp | 0    | 时间戳                                    | 不为空   |

##### assignment_experiment 作业实验关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| assignmentId | varchar   | 32   | 作业id，uuid         | 不为空   |
| experimentId | varchar   | 32   | 实验id，uuid         | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### assignment_experiment_user 作业实验用户关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| assignmentId | varchar   | 32   | 作业id，uuid         | 不为空   |
| userId       | varchar   | 32   | 用户id，uuid         | 不为空   |
| experimentId | varchar   | 32   | 实验id，uuid         | 不为空   |
| roleId       | varchar   | 32   | 用户角色id，uuid     | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### student_assignment 学生作业表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 25   | 主键id，uuid，不自增 | 不为空   |
| name         | varchar   | 45   | 作业名称             | 不为空   |
| number       | int       | 3    | 作业题目数量         | 不为空   |
| choiceNumber | int       | 3    | 选择题数量           | 不为空   |
| choiceScore  | int       | 3    | 选择题每题分数       | 不为空   |
| answerNumber | int       | 3    | 简答题数量           | 不为空   |
| answerScore  | int       | 3    | 简答题每题分数       | 不为空   |
| tfNumber     | int       | 3    | 判断题题目数量       | 不为空   |
| tfScore      | int       | 3    | 判断题题目每题分数   | 不为空   |
| totalScore   | int       | 3    | 作业总分数           | 不为空   |
| stduentScore | int       | 3    | 学生得分数           | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### student_assignment_choiceQuestion 学生回答选择题表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| topic        | varchar   | 45   | 题目                 | 不为空   |
| option       | varchar   | 16   | 学生选择的选项       | 不为空   |
| optionAnswer | varchar   | 1000 | 选项的答案           | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |

##### student_assignment_answerQuestion 学生回答简答题表

| 字段   | 类型      | 长度 | 说明                 | 是否为空 |
| ------ | --------- | ---- | -------------------- | -------- |
| id     | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| topic  | text      | 0    | 题目                 | 不为空   |
| answer | text      | 0    | 学生答案             | 不为空   |
| date   | timestamp | 0    | 时间戳               | 不为空   |

##### student_assignment_tfQuestion 学生回答判断题表

| 字段   | 类型      | 长度 | 说明                   | 是否为空 |
| ------ | --------- | ---- | ---------------------- | -------- |
| id     | varchar   | 32   | 主键id，uuid，不自增   | 不为空   |
| topic  | varchar   | 45   | 题目                   | 不为空   |
| answer | int       | 1    | 学生答案，0为对，1为错 | 不为空   |
| date   | timestamp | 0    | 时间戳                 | 不为空   |

##### stduent_assignment_question 学生作业题目关系表

| 字段         | 类型      | 长度 | 说明                 | 是否为空 |
| ------------ | --------- | ---- | -------------------- | -------- |
| id           | varchar   | 32   | 主键id，uuid，不自增 | 不为空   |
| assignmentId | varchar   | 32   | 作业id，uuid         | 不为空   |
| questionId   | varchar   | 32   | 问题Id，uuid         | 不为空   |
| questionType | int       | 1    | 问题类型             | 不为空   |
| date         | timestamp | 0    | 时间戳               | 不为空   |



#### 架构搭建

##### 父工程

simulation-project

pom文件

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>cn.xuxiaonan</groupId>
  <artifactId>simulation-project</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>simulation-project-api</module>
    </modules>

    <name>simulation-project</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <!-- 编码格式 -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <!-- 默认的jdk的版本 -->
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <!-- junit的测试版本 -->
    <junit.version>4.12</junit.version>
    <!-- 小辣椒的版本 -->
    <lombok.version>1.16.18</lombok.version>
  </properties>


  <dependencies>
    <!-- springCloud的坐标 -->
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-dependencies</artifactId>
      <version>Dalston.SR1</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
    <!-- springboot的坐标 -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <version>2.1.3.RELEASE</version>
    </dependency>
    <!-- mysql的坐标 -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.0.4</version>
    </dependency>
    <!-- 阿里的数据源 -->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.0.31</version>
    </dependency>
    <!-- mybatis与springboot的依赖 -->
    <dependency>
      <groupId>org.mybatis.spring.boot</groupId>
      <artifactId>mybatis-spring-boot-starter</artifactId>
      <version>1.3.0</version>
    </dependency>
    <!-- 小辣椒 -->
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-core</artifactId>
      <version>1.2.3</version>
    </dependency>
    <!-- junit的测试依赖 -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>${junit.version}</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
        <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.7.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>
```

##### 公共的API系统

simulation-project-api

- 公用的实体类

  entities存放公用的实体类信息

  base用于创建对象时自定义UUID的主键和当前时间

- 公用的工具类

  apiUtil使用的是第三方的工具包

  ​	JsonDateValueProcessor：list转换为json时使用的自定义的时间序列化的包

  ​	MyPoi：excel的导入导出工具包

  FileUtil：文件工具

  JsonUtil：寄送格式化以及转换工具

  RandomNumberUtil：UUID生成工具

  ResponseUtil：返回信息封装工具

  TimeUtil：时间工具

- 枚举类

  Character：符号枚举类

  ErrorMessage：错误信息枚举类

  ReturnCode：返回代码及相关信息枚举类

##### Eureka服务注册系统

simulation-project-eureka

注意：使用到任何的微服务，微服务首先需要注册到eureka注册中心中，因此eureka需要先启动，若eureka配置了集群，则需要先启动eureka集群

eureka的yml配置文件

```yml
server:
  port: 7001

eureka:
  instance:
    hostname: eureka7001.com #eureka服务端的实例名称
  client:
    register-with-eureka: false     #false表示不向注册中心注册自己。
    fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/       #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址（单机）。
```

##### 服务提供者

simulation-project-user

通过相应的三层架构获取需要的数据不再赘述

服务提供者注册到注册中心

yml文件配置

```yml
##当前微服务的名称
spring:
  application:
    name: simulation-project-user
eureka:
  client: #客户端注册进eureka服务列表内
    service-url: ##注册地址
      defaultZone: http://localhost:7001/eureka
  instance:
    instance-id: simulation-project-user   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址
## 微服务的详细信息
info:
  app.name: simulation-project-user
  company.name: cn.xuxiaonan
  build.artifactId: $project.artifactId$
  build.version: $project.version$
```

主启动类

```java
@SpringBootApplication
@MapperScan(value = "cn.xuxiaonan.simulationprojectuser.mapper")
@EnableEurekaClient
public class SimulationProjectUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimulationProjectUserApplication.class, args);
    }

}
```

##### 微服务网关

simulation-project-zuul

```yml
server:
  port: 9527

spring:
  application:
    name: simulation-project-zuul
## 注册到eureka
eureka:
  client:
    service-url:
      defaultZone: http://localhost:7001/eureka/
  instance:
    instance-id: gateway-9527.com
    prefer-ip-address: true
## 网关配置
zuul:
  ##统一前缀
  ## 忽略原微服务名称
  ignored-services: "*"
  routes:
    mydept.serviceId: simulation-project-user
    mydept.path: /user/**
  prefix: /simulation

info:
  app.name: simulation-project-zuul
  company.name: cn.xuxiaonan
  build.artifactId: $project.artifactId$
  build.version: $project.version$
```

主启动类

```java
@SpringBootApplication
@EnableZuulProxy
public class SimulationProjectZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimulationProjectZuulApplication.class, args);
    }

}
```

##### session共享服务

注意：session服务模块创建session后，其余模块需要导入依赖和使用@EnableRedisHttpSession注解使用session共享，在api系统中导入对应的依赖包

pom文件(存入api)

```xml
<!--SpringSession依赖-->
        <dependency>
            <groupId>org.springframework.session</groupId>
            <artifactId>spring-session-data-redis</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        <!-- spring security web包 -->
        <!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-web -->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-web</artifactId>
            <version>4.2.3.RELEASE</version>
        </dependency>
```

yml配置文件

```yml
## 端口
server:
  port: 8090
spring:
  application:
    name: simulation-project-session
  ## redis配置
  redis:
    host: 
    port: 
    timeout: 6000ms
    lettuce:
      pool:
        max-active: 8
        max-wait: -1ms
        max-idle: 8
        min-idle: 0
    database: 4
## eureka客户端配置
eureka:
  client: #客户端注册进eureka服务列表内
    service-url:
      defaultZone: http://localhost:7001/eureka
  instance:
    instance-id: simulation-project-session   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址
info:
  app.name: simulation-project-session
  company.name: cn.xuxiaonan
  build.artifactId: $project.artifactId$
  build.version: $project.version$
```

session共享配置类

```java
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
```

通过创建session并自动进行redis的缓存，在其他模块调用session即可保证session的一致性

##### Shiro权限认证

simulation-project-shiro

pom文件

```xml
<dependencies>
        <!-- 公用api -->
        <dependency>
            <groupId>cn.xuxiaonan</groupId>
            <artifactId>simulation-project-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!-- springboot依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- mybatis依赖 -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.0.1</version>
        </dependency>
        <!-- eureka依赖 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!-- druid数据源 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.20</version>
        </dependency>
        <!-- mysql驱动依赖 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!-- shiro依赖 -->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-spring</artifactId>
            <version>1.3.2</version>
        </dependency>
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-core</artifactId>
            <version>1.3.2</version>
        </dependency>
        <!-- springboot test 测试依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
```

yml配置文件

```yml
##数据源配置
spring:
  application:
    name: simulation-project-shiro
  ## redis配置
  redis:
    host: 
    port: 
    timeout: 6000ms
    lettuce:
      pool:
        max-active: 8
        max-wait: -1ms
        max-idle: 8
        min-idle: 0
    database: 4
  datasource:
    username: 
    password: 
    url: jdbc:mysql:///wisdombrain?useSSL=false
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

## 该配置节点为独立的节点，有很多同学容易将这个配置放在spring的节点下，导致配置无法被识别
mybatis:
  config-location: classpath:mybatis/mybatis-config.xml
  mapper-locations: classpath:mybatis/mapper/*.xml
## 端口配置
server:
  port: 8085
  use-forward-headers: true
  tomcat:
    remote-ip-header: x-forwarded-for
    protocol-header: x-forwarded-proto
    port-header: X-Forwarded-Port
    #其它设置是让Tomcat去Http头信息去获取协议信息，而不是从HttpServletRequest
    internal-proxies: 192\.168\.\d{1,3}\.\d{1,3}
## eureka客户端配置
eureka:
  client: #客户端注册进eureka服务列表内
    service-url:
      defaultZone: http://localhost:7001/eureka
  instance:
    instance-id: simulation-project-shiro   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址
info:
  app.name: simulation-project-shiro
  company.name: cn.xuxiaonan
  build.artifactId: $project.artifactId$
  build.version: $project.version$

```

shiro config配置类

```java
/***
 * @author dinggc
 * Description //Shiro的配置文件
 * Date 下午5:02 18-12-31
 * Param
 * return
 **/
@Configuration
public class ShiroConfig {
    /**
     * @author dinggc
     * Description //ShiroFilterFactoryBean 处理拦截资源文件问题
     *      * 注意：单独一个ShiroFilterFactoryBean配置是会报错的，因为在初始化ShiroFilterFactoryBean
     *      * 的时候需要注入：SecurityManager
     *      *
     *      * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔
     *      * 2、设置多个过滤器时，全部验证通过才为通过
     *      * 3、部分过滤器可指定参数
     * Date 下午5:02 18-12-31
     * Param [securityManager]
     * return org.apache.shiro.spring.web.ShiroFilterFactoryBean
     **/
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        //必须设置SecurityManager
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //如果不设置默认会自动寻找web工程目录下的login.jsp页面
        shiroFilterFactoryBean.setLoginUrl("/user/signIn");
        // 登录成功后要跳转的链接
        //未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/authorization");

        //自定义拦截器
        Map<String, Filter> filterMap = new LinkedHashMap<String,Filter>();
        //限制同一账号同时在线的个数
        //filterMap.put("kickout",kickoutSessionControlFilter);
        shiroFilterFactoryBean.setFilters(filterMap);

        // 权限控制map.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/user/login","authc");
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        // 从数据库获取动态的权限
        // filterChainDefinitionMap.put("/add", "perms[权限添加]");
        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //logout这个拦截器是shiro已经实现好了的。
        // 从数据库获取
        /*List<SysPermissionInit> list = sysPermissionInitService.selectAll();
        for (SysPermissionInit sysPermissionInit : list) {
            filterChainDefinitionMap.put(sysPermissionInit.getUrl(),
                    sysPermissionInit.getPermissionInit());
        }*/

        shiroFilterFactoryBean
                .setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    /***
     * @author dinggc
     * Description //引入realm配置类
     * Date 下午5:03 18-12-31
     * Param []
     * return org.apache.shiro.mgt.SecurityManager
     **/
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myShiroRealm());
        // 自定义缓存实现 使用redis
        //securityManager.setCacheManager(cacheManager());
        // 自定义session管理 使用redis
        //securityManager.setSessionManager(sessionManager());
        //注入记住我管理器;
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    @Bean
    public ShiroRealm myShiroRealm(){
        return new ShiroRealm();
    }

    /***
     * @author dinggc
     * Description //Cookie对象
     * Date 下午5:04 18-12-31
     * Param []
     * return org.apache.shiro.web.servlet.SimpleCookie
     **/
    @Bean
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(2592000);
        return simpleCookie;
    }

    /***
     * @author dinggc
     * Description //实现记住我的功能
     * Date 下午5:04 18-12-31
     * Param []
     * return org.apache.shiro.web.mgt.CookieRememberMeManager
     **/
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }
    /***
     * @author dinggc
     * Description //使用Shiro注解
     * Date 下午5:04 18-12-31
     * Param [securityManager]
     * return org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
     **/
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor
                = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    /***
     * @author dinggc
     * Description //使用AOP的代理
     * Date 下午5:05 18-12-31
     * Param []
     * return org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator
     **/
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
}
```

realm进行用户认证和权限认证

```java
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;

    /***
     * @author dinggc
     * Description //授权用户权限
     * Date 上午8:43 19-1-2
     * Param [principalCollection]
     * return org.apache.shiro.authz.AuthorizationInfo
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从principals获取主身份信息
        //将getPrimaryPrincipal方法返回值转为真实身份信息(在上边的doGetAuthecticationInfo认证通过填充到SimpleAuthenticationInfo)
        User user = (User) principalCollection.getPrimaryPrincipal();
        //根据信息获取权限信息
        //连接数据库。。。
        //模拟从数据库获取到数据
        List<Permission> permissions = null;
        try {
            permissions = userService.getPermissionById(user.getId());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //...
        List<String> permission = new ArrayList<String>();
        for(Permission syspermission:permissions) {
            permission.add(syspermission.getPermission());
        }
        //查询到权限数据，返回
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将上边查询到授权信息填充到simpleAuthorizationInfo对象中
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /***
     * @author dinggc
     * Description //验证用户身份
     * Date 上午8:43 19-1-2
     * Param [authenticationToken]
     * return org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = null;
        try {
            user = userService.getUserInfo(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(user==null){
            return null;
        }
        String PIN = user.getPassword();
        return new SimpleAuthenticationInfo(user,PIN,getName());
    }
}
```

主启动类

```java
@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
@MapperScan(value = "cn.xuxiaonan.simulationprojectshiro.mapper")
public class SimulationProjectShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimulationProjectShiroApplication.class, args);
    }

}
```

根据shiro的配置类进行连接的拦截并进行对应的跳转和权限的认证

业务逻辑和普通的三层架构类似，不在赘述

##### Elasticsearch搜索服务

simulation-project-es

pom文件

```xml
<dependencies>
        <!-- 公用api依赖 -->
        <dependency>
            <groupId>cn.xuxiaonan</groupId>
            <artifactId>simulation-project-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!-- ES依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
            <version>2.1.5.RELEASE</version>
        </dependency>
        <!-- springboot依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- mysql -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!-- mybatis -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.0.1</version>
        </dependency>
        <!-- eureka依赖 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!-- springboot test 依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

yml配置文件

注意：连接elasticsearch的时候需要使用java的9300端口，如果连接失败，进入elasticsearch的配置文件开放transport允许所有外网ip进入

注意：若elasticsearch作为docker容器出现闪退的情况，需要修改对应的jvm配置文件，修改给予的内存即可

```yml
## 端口设置
server:
  port: 8087
spring:
  application:
    name: simulation-project-es
  datasource:
    username: 
    password: 
    url: jdbc:mysql:///wisdombrain?useSSL=false
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
  ## redis配置
  redis:
    host: 
    port: 
    timeout: 6000ms
    lettuce:
      pool:
        max-active: 8
        max-wait: -1ms
        max-idle: 8
        min-idle: 0
    database: 4
  data:
    ## es配置
    elasticsearch:
      cluster-nodes: 
      cluster-name: elasticsearch
## eureka客户端配置
eureka:
  client: #客户端注册进eureka服务列表内
    service-url:
      defaultZone: http://localhost:7001/eureka
  instance:
    instance-id: simulation-project-es   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址
info:
  app.name: simulation-project-es
  company.name: cn.xuxiaonan
  build.artifactId: $project.artifactId$
  build.version: $project.version$
## 该配置节点为独立的节点，有很多同学容易将这个配置放在spring的节点下，导致配置无法被识别
mybatis:
  config-location: classpath:mybatis/mybatis-config.xml
  mapper-locations: classpath:mybatis/mapper/*.xml
```

主启动类

注意：当整合了elasticsearch之后，又整合redis，启动报错，可以在主启动类中加入System.setProperty("es.set.netty.runtime.available.processors", "false");

```java
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(value = "cn.xuxiaonan.simulationprojectes.mapper")
public class SimulationProjectEsApplication {
    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(SimulationProjectEsApplication.class, args);
    }

}
```

entities

New为测试，使用elasticsearch的注解来插入到elasticsearch的数据库中，否则类型数据不匹配

```java
@Document(indexName = "simulation",type = "news",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class New implements Serializable {
    @Id
    private String id;
    /**
     * 标题
     **/
    private String title;
    /**
     * 新闻内容
     **/
    private String xwnr;
    /**
     * 新闻的封面图片id
     **/
    private String fmtpId;
    /**
     * 发表的机构
     **/
    private String fbjg;
    /**
     * 是否为草稿状态
     **/
    private int sfwcg;
    /**
     * 审核状态
     **/
    private int shzt;
    /**
     * 阅读量
     **/
    private int ydl;
    /**
     * 时间
     **/
    private Date date;
    /**
     * 更新时间
     **/
    private Date gxdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getXwnr() {
        return xwnr;
    }

    public void setXwnr(String xwnr) {
        this.xwnr = xwnr;
    }

    public String getFmtpId() {
        return fmtpId;
    }

    public void setFmtpId(String fmtpId) {
        this.fmtpId = fmtpId;
    }

    public String getFbjg() {
        return fbjg;
    }

    public void setFbjg(String fbjg) {
        this.fbjg = fbjg;
    }

    public int getSfwcg() {
        return sfwcg;
    }

    public void setSfwcg(int sfwcg) {
        this.sfwcg = sfwcg;
    }

    public int getShzt() {
        return shzt;
    }

    public void setShzt(int shzt) {
        this.shzt = shzt;
    }

    public int getYdl() {
        return ydl;
    }

    public void setYdl(int ydl) {
        this.ydl = ydl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getGxdate() {
        return gxdate;
    }

    public void setGxdate(Date gxdate) {
        this.gxdate = gxdate;
    }
}

```

Repository

实现elasticsearch的接口，定义自己的实体类和主键类型

```java
@Component
public interface NewsRepository extends ElasticsearchRepository<New,String> {
}
```

使用repository进行elasticsearch的增删改查，不在赘述

##### rabbitMq消息中间件服务

simulation-project-rabbitmq

pom文件

```xml
<dependencies>
        <!-- 公用api -->
        <dependency>
            <groupId>cn.xuxiaonan</groupId>
            <artifactId>simulation-project-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!-- rabbitmq 依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-amqp</artifactId>
        </dependency>
        <!-- springboot 依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- eureka依赖 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!-- 容错依赖 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>
        <!-- springboot test 依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

yml配置文件

```yml
##端口配置
server:
  port: 9091
spring:
  application:
    name: simulation-project-rabbitmq
  ## rabbitmq配置
  rabbitmq:
    host: 
    username: 
    password: 
    port: 5672
  ## redis配置
  redis:
    host: 
    port: 
    timeout: 6000ms
    lettuce:
      pool:
        max-active: 8
        max-wait: -1ms
        max-idle: 8
        min-idle: 0
    database: 4
## eureka客户端配置
eureka:
  client: #客户端注册进eureka服务列表内
    service-url:
      defaultZone: http://localhost:7001/eureka
  instance:
    instance-id: simulation-project-rabbitmq   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址
info:
  app.name: simulation-project-rabbitmq
  company.name: cn.xuxiaonan
  build.artifactId: $project.artifactId$
  build.version: $project.version$
```

订阅模式

FanoutRabbitConfig设置订阅模式，创建一个exchange，添加一个fanout.news的队列。

```java
/***
* @Description: 订阅模式
* @Author: dinggc
* @Date: 2019/6/5
*/
@Configuration
public class FanoutRabbitConfig {
    @Bean
    public Queue NewsMessage() {
        return new Queue(RabbitMq.FANOUTNEWS.getName());
    }
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitMq.FANOUTEXCHANGE.getName());
    }
    @Bean
    Binding bindingExchangeNews(Queue NewsMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(NewsMessage).to(fanoutExchange);
    }
}
```

向队列中存入信息

```java
 /**
    * @Description:  向订阅模式中发送信息
    * @Param: [msg]
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/5
    */
    @RequestMapping(value = "send")
    @ResponseBody
    public Object send(@RequestParam("msg") String msg){
        JSONObject jsonObject = new JSONObject();
        try {
            amqpTemplate.convertAndSend(RabbitMq.FANOUTEXCHANGE.getName(),"",msg);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
```

设置监听器，若队列中存入信息，则取出，业务逻辑(当数据库中的新闻信息变动后，向消息中间件中存入提示信息，监听队列信息后，进行elasticsearch数据的更新)

相应的api仍然通过fegin进行远程调用

```java
/***
* @Description: 订阅模式的监听
* @Author: dinggc
* @Date: 2019/6/5
*/
@Component
@RabbitListener(queues = "fanout.News")
public class NewsReceiver {
    @Autowired
    RabbitService rabbitService;
    @RabbitHandler
    public void receiver(String msg){
        rabbitService.saveNews();
        System.out.println(msg);
    }
}
```

##### ELK日志系统

服务器上安装elasticsearch，logstash和kibana

注意：elasticsearch和kibana大版本需要保持一致，kibana的小版本需要低于elasticsearch的小版本

若使用docker启动出现容器闪退的情况，则配置jvm的对应的内存，或者在启动容器时指定容器的内存

logstash和kibana需要配置配置文件和elasticsearch进行连接

使用elasticsearch-head对elasticsearch进行监控

ELK整合springboot

pom依赖

```xml
<!-- logstash 依赖 -->
        <dependency>
            <groupId>net.logstash.logback</groupId>
            <artifactId>logstash-logback-encoder</artifactId>
            <version>5.2</version>
        </dependency>
        <!--可以引入日志 @Slf4j注解-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.16.20</version>
        </dependency>
```

logback-spring.xml配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <include resource="org/springframework/boot/logging/logback/base.xml" />

    <appender name="LOGSTASH" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
        <destination>:5044</destination>
        <encoder charset="UTF-8" class="net.logstash.logback.encoder.LogstashEncoder" />
    </appender>

    <root level="INFO">
        <appender-ref ref="LOGSTASH" />
        <appender-ref ref="CONSOLE" />
    </root>
</configuration>
```

yml配置文件打印sql语句

```yml
## sql语句
logging:
  level:
    cn.xuxiaonan.simulationprojectuser.mapper: debug
```

使用@Slf4j注解打印日志信息

注意：若无法使用slf4j的log变量，请下载lombok插件

```java
@Controller
@RequestMapping(value = "/api")
@Slf4j
public class NewsController {
        /**
     * @Author dinggc
     * @Description //新闻数据接口
     * @Date 12:50 2019/5/28
     * @Param []
     * @return java.lang.Object
     **/
    @RequestMapping(value = "news/getNewsList")
    @ResponseBody
    public Object getNewsList(){
        List<New> newsList = newsService.getNewsList();
        log.info("get all news");
        return JsonUtil.changeListToJson(newsList);
    }
}
```

##### 服务消费者

simulation-project-web

```yml
server:
  port: 80
## 容错
feign:
  hystrix:
    enabled: true
## 发现微服务
eureka:
  client:
    register-with-eureka: false
    serviceUrl:
      defaultZone: http://localhost:7001/eureka/
```

主启动类

```java
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableFeignClients
public class SimulationProjectWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimulationProjectWebApplication.class, args);
    }

}
```

serviceFallbackFactory容错机制

@Component一定要添加 否则报错

```java
@Component
public class NewsClientServiceFallbackFactory implements FallbackFactory<NewsService> {
    @Override
    public NewsService create(Throwable throwable) {
        return new NewsService() {
            @Override
            public List<New> getNewsList() {
                New news = new New();
                news.setXwnr("current server is error");
                return ResponseUtil.hystrixError(news);
            }
        };
    }
}
```

service通过网关调用微服务，不直接和微服务进行交互

```java
@FeignClient(value = "SIMULATION-PROJECT-ZUUL",fallbackFactory = NewsClientServiceFallbackFactory.class)
public interface NewsService {
    /**
     * @Author dinggc
     * @Description //微服务调用
     * @Date 13:58 2019/5/28
     * @Param []
     * @return java.lang.Object
     **/
    @RequestMapping(value = "simulation/user/api/news/getNewsList")
    @ResponseBody
    Object getNewsList();
}
```

##### 用户系统 

##### 实验管理系统

##### 实验流程管控系统

##### 实验评分反馈系统

##### 实验数据信息处理系统

##### 检索系统

##### 推荐系统

##### 审核系统
