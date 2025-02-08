# ✨ 基于双向适配喵咕登录平台 README

欢迎来到**喵咕登录平台**的项目文档 (≧▽≦)！本项目是一个基于**Spring Boot**的前后端不分离的登录平台，采用JPA和MyBatis双向适配的设计模式，旨在提升系统的灵活性和可扩展性 (｡•̀ᴗ-)。通过本项目，您将深入了解设计模式在实际开发中的应用。 (≧◡≦) ♡

## 1. 🌟 引言

在当今快速迭代的软件开发领域中，设计模式扮演着举足轻重的角色。它们如同一套精心雕琢的工具，能够显著提升代码的可复用性、可维护性和可扩展性。通过合理运用设计模式，我们可以有效降低系统间的耦合度，优化代码结构，从而打造出更加健壮、灵活的软件产品。本项目旨在通过实践深化对设计模式的理解，并将其应用于实际开发中。 (*≧ω≦)

## 2. 📚 项目背景

秉承“学以致用”的核心理念，我们开发了这个集多种设计模式于一体的喵咕登录平台。项目旨在通过实践来掌握并应用实际Web开发中可能遇到的设计模式，以提升系统的灵活性和可扩展性。核心在于实现JPA和MyBatis两大ORM框架的双向适配，利用设计模式的力量，让开发者能够在项目中灵活切换不同的ORM框架，以适应不同的业务需求和技术环境。 (｡•̀ᴗ-)

### 技术栈 💻

- **前端**: JavaScript + HTML + CSS、JQuery 
- **后端**: Spring Boot + Kotlin + MyBatis + JPA + Maven + MySQL，MVC架构 
- **设计模式**: 双向适配器、自动代理、依赖注入、观察者模式、职责链模式 
- **服务器**: Spring Boot 
- **API测试工具**: IntelliJ IDEA Http测试 
- **IDE工具**: IntelliJ IDEA 

## 3. 🛠️ 设计模式

### 3.1 ⚙️ 适配器模式

适配器模式在本项目中发挥了至关重要的作用，使得JPA和MyBatis能够无缝集成。通过创建一个适配器类，我们统一了两者的接口，使得开发者可以在同一项目中根据需要灵活选择ORM框架。

**适配器模式的优势**:
- **缓冲技术更迭**: 为新老技术框架的交替提供了良好的过渡方案。
- **优势互补**: JPA简洁高效，MyBatis擅长处理复杂SQL，两者并用，相得益彰。

### 3.2 🔗 职责链模式

在用户注册时，职责链模式用于链式登录验证。每个验证环节（如用户查重、密码强度、邮箱格式等）都由一个处理器负责，形成一个链条，简化了验证逻辑的管理 (≧∇≦)/

#### 3.2.1 📋 职责链模式实现细节

- 抽象职责链Handler: 负责定义处理链的基本结构和方法。
- 用户名查重职责链Handler: 检查用户名是否已被注册，避免重复。
- 邮箱格式检查链: 确保用户输入的邮箱格式正确。
- 密码强度检查链: 验证用户密码的强度，确保安全性。
- 用户职责链表: 方便管理各个验证环节，提升代码可读性。 

### 3.3 👀 观察者模式

观察者模式用于实现邮箱验证和未来可能的事件监听器。用户注册时，系统会自动发送验证邮件，并可能记录邮件信息等操作，能够在未来扩展更多监听器功能 (≧▽≦)。

#### 3.3.1 📧 观察者模式实现细节

- 用户观察者接口: 定义观察者的基本行为。
- 邮箱观察者实现: 具体实现邮件发送功能。
- 观察者目标: 适配器的一部分，负责管理观察者的注册和通知。

## 4. 🎉 效果展示

### 4.1 📝 注册功能展示

1. **基础注册页面**: 用户填写个人信息并提交。
2. **用户名已存在**: 当用户名已存在于数据库中时，系统给出提示。
3. **密码强度弱**: 当用户输入的密码强度不符合要求时，系统给出提示并建议增强密码。 

> 解释：职责链中，无法展示邮箱格式不符合的情形，因为前端表单提交之前已经自动阻挡邮箱格式不符的情况。

### 4.2 🔑 登录功能展示

1. **登录基础页面**: 用户输入用户名和密码进行登录。
   ![image](https://github.com/user-attachments/assets/9f5de5bc-a248-4216-8ddf-e9d69f467d8c)

2.  **登录用户名或密码错误**: 当用户名或密码错误时，系统给出提示。
   ![image](https://github.com/user-attachments/assets/294c81f1-70f8-46e4-9e2f-300d47acd0bd)

5. **登录注册成功演示**: 登录注册成功后进入主页。由于主页尚未完成，展示CSS动画表示正在开发(≧∇≦)/。 
![image](https://github.com/user-attachments/assets/8327b60d-247e-4651-8906-f59138370d62)

## 5. 📂 项目结构

项目采用分层架构，主要分为以下几个模块：

- **adapter**: 该模块实现了适配器模式，用于适配不同的ORM框架(JPA和MyBatis)。通过创建统一的仓储接口，开发者可以灵活切换使用不同的ORM框架。 
  
- **chain**: 该模块实现了职责链模式，用于处理用户注册时的各种验证逻辑，如密码强度、邮箱格式等。每个验证环节都由一个处理器负责，形成一个链条。
  
- **config**: 该模块包含项目的各种配置信息，如数据库连接、Spring Security等。
  
- **controller**: 该模块负责处理HTTP请求，调用服务层完成业务逻辑。
- 
- **dto**: 该模块定义数据传输对象(Data Transfer Object)，用于在层与层之间传递数据。
  
- **entity**: 该模块定义数据库实体，与数据库表一一对应。
  
- **handler**: 该模块实现了处理器接口，用于职责链模式中的各个验证环节。 
  
- **observer**: 该模块实现了观察者模式，用于在用户注册时发送验证邮件，并可以扩展更多的监听器功能。 
  
- **repository**: 该模块定义了数据访问层的接口，由适配器模块提供具体的实现。 
  
- **service**: 该模块实现了业务逻辑，调用仓储层完成数据操作。 
通过这种分层架构，各个模块职责明确，耦合度低，有利于代码的维护和扩展。同时，通过设计模式的应用，进一步提高了系统的灵活性和可扩展性。

## 6. 🚀 未来展望

未来，我们将继续优化该项目，考虑引入缓存机制、AOP等软件包，以进一步提升系统性能和可维护性。同时，前端可能会使用Fetch API进行服务调用，增强用户体验。 (๑•̀ᴗ-)

感谢您对喵咕登录平台的关注与支持！如有任何问题或建议，欢迎随时联系开发团队！ (≧◡≦) ♡
