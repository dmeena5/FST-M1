from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/dynamic-attributes")
    print("The title of the page is: ", driver.title)
    #Find the username and password input fields. Type in the credentials:
    #username: admin
    #password: password
    username = driver.find_element(By.XPATH,"//input[starts-with(@class,'username-')]")
    password = driver.find_element(By.XPATH,"//input[starts-with(@class,'password-')]")
    username.send_keys("admin")
    password.send_keys("password")
    driver.find_element(By.XPATH, "//button[@type='submit']").click()
    #Wait for login message to appear and print the login message to the console
    wait = WebDriverWait(driver,10)
    wait.until(EC.visibility_of_element_located((By.ID,"action-confirmation")))
    login_msg = driver.find_element(By.ID,"action-confirmation")
    print("Login message is: ", login_msg.text)