from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.common.by import By

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/dynamic-controls")
    print("The title is: ", driver.title)
    toggleButton = driver.find_element(By.ID, "toggleCheckbox")
    checkbox = driver.find_element(By.ID, "dynamicCheckbox")
    toggleButton.click()
    print("Checkbox hidden")
    wait = WebDriverWait(driver, 10)
    wait.until(expected_conditions.invisibility_of_element(checkbox))
    toggleButton.click()
    print("Checkbox visible")
    checkbox.click()
    print("Checkbox selected")
    driver.quit()
