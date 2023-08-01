#Logging into the site
#Goal: Open the site and login with the credentials provided

from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.remote.webdriver import By

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Initialize wait object
    wait = WebDriverWait(driver, 10)

    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/crm/")
    print("Home Page Title is: " + driver.title)
    # Logging into the site
    driver.find_element(By.ID, "user_name").send_keys("admin")
    driver.find_element(By.ID,"username_password").send_keys("pa$$w0rd")
    driver.find_element(By.XPATH,"//*[@id=\"bigbutton\"]").click()
    message = driver.find_element(By.ID,"moduleTab_Home").get_attribute("href")
    print(message)
    