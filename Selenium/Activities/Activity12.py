from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://training-support.net/selenium/dynamic-controls")
    print("The title of the page is: ", driver.title)
    wait = WebDriverWait(driver, 10)
    text_field = driver.find_element(By.ID, "input-text")
    print("The text field is enabled: ", text_field.is_enabled())
    toggle_button = driver.find_element(By.ID,"toggleInput")
    toggle_button.click()
    print("The text field is enabled: ", text_field.is_enabled())
    text_field.send_keys("Enter Input")
    wait.until(EC.visibility_of_element_located((By.ID,"input-text")))
    print("The text in the input field is: ", text_field.get_attribute("value"))
