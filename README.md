Да се разработи Java Maven test automation проект на база на следните технологии: TestNG и Selenium WebDriver.
За организация на проекта да се следва Page Object Model design pattern и PageFactory.
Да се автоматизират не по-малко от 5 различни тестови сценария срещу следния уебсайт: http://training.skillo-bg.com:4200/posts/all
Проектът да съдържа testng.xml файл.
Всички тестове да могат да се изпълнят с командата 'mvn clean test' срещу Chrome browser.
При test failure, да се запазва screenshot в избрана директория от проекта.
Да бъде създадено публично github repo, в което да се съхранява кода на проекта.
Проектът да съдържа README файл, който да описва какво представлява проекта и какви тестове съдържа.

LikePost
- Open homepage.
- Login with existing user.
- Redirect to homepage.
- Check if the latest post has been already liked.
- Like the post if it wasn't liked before.
- Verify that the class name of the button is changed.

DislikePost
- Open homepage.
- Login with existing user.
- Redirect to homepage.
- Check if the latest post has been already disliked.
- Dislike the post if it wasn't disliked before.
- Verify that the class name of the button is changed.

FollowUser
- Open homepage.
- Login with existing user.
- Redirect to homepage.
- Check if the latest user has been already followed.
- Follow the user if it wasn't followed before.
- Verify that the button is now Unfollow.

UnfollowUser
- Open homepage.
- Login with existing user.
- Redirect to homepage.
- Check if the latest user has been already unfollowed.
- Unfollow the user if it wasn't unfollowed before.
- Verify that the button is now Follow.
- 
UserLogin
- Open homepage.
- Login with existing user.
- Check if the user is logged in.

UserLogout
- Open homepage.
- Login with existing user.
- Check if the user is logged in.
- Logout.
- Check if the user is logged out.

=======
