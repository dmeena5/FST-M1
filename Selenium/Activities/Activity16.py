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
    username = driver.find_element(By.XPATH,"//input[contains(@class,'-username')]")
    password = driver.find_element(By.XPATH,"//input[contains(@class,'-password')]")
    confirmPassword = driver.find_element(By.XPATH,"//label[contains(text(), 'Confirm Password')]//following::input")
    email = driver.find_element(By.XPATH,"//input[contains(@class,'email-')]")
    username.send_keys("Deku")
    password.send_keys("PlusUltra!")
    confirmPassword.send_keys("PlusUltra!")
    email.send_keys("deku@ua.edu")
    driver.find_element(By.XPATH,"//button[text()='Sign Up']").click()
    wait = WebDriverWait(driver, 10)
    wait.until(EC.visibility_of_element_located((By.ID,"action-confirmation")))
    login_msg = driver.find_element(By.ID, "action-confirmation")
    print("login message is: ", login_msg.text)



