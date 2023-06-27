from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.remote.webdriver import By
from selenium.webdriver.support.select import Select

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service = service) as driver:
    driver.get("https://www.training-support.net/selenium/login-form")
    print("The title of the page is: ", driver.title)
    driver.find_element(By.ID, "username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")
    driver.find_element(By.XPATH, "//*[@id='dynamic-attributes-form']/div/button").click()
    message = driver.find_element(By.ID, "action-confirmation")
    print("confirmation message is: ", message.text)
    driver.quit()
