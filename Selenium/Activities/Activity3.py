from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.remote.webdriver import By
from selenium.webdriver.support.select import Select


# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    driver.get("https://www.training-support.net/selenium/login-form")
    
    print("Page title is: ", driver.title)

    driver.find_element(By.XPATH, "//input[@id='username']").send_keys("admin")
    driver.find_element(By.XPATH, "//input[@id='password']").send_keys("password")

    driver.find_element(By.XPATH, "//button[@type='submit']").click()
   
    message = driver.find_element(By.XPATH, "//div[@id='action-confirmation']")
    print("Login message: ", message.text)

    driver.quit()