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
- Go to profile page.
- Open the latest post.
- Like the post.
- Verify that the like icon is changed.
- Check if the pop-up confirmation has appeared.

DislikePost
- Open homepage.
- Login with existing user.
- Go to profile page.
- Open the latest post, that is already liked.
- Dislike the post.
- Verify that the dislike icon is changed.
- Check if the pop-up confirmation has appeared.

FollowUser
- Open homepage.
- Login with existing user.
- Go to profile page.
- Get number of current followers.
- Go to search field.
- Find specific person and follow him/her. - (The user will be "EvgAngelov")
- Go to my profile and verify that following number is increased.

UnfollowUser
- Open homepage.
- Login with existing user.
- Go to profile page.
- Get number of current followers.
- Go to search field.
- Find specific person and unfollow him/her. - (The user will be "EvgAngelov")
- Go to my profile and verify that following number is decreased.

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