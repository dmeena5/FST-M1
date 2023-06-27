from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.common.by import By

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/ajax")
    print("The title is: " , driver.title)
    wait = WebDriverWait(driver, 10)
    driver.find_element(By.CSS_SELECTOR, "#ajax-content > button").click()
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h1"),"HELLO!"))
    hello_text = driver.find_element(By.TAG_NAME, "h1").text
    print("The text is: ", hello_text)
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"),"I'm late!"))
    late_text = driver.find_element(By.TAG_NAME, "h3").text
    print("The text is: ", late_text)
