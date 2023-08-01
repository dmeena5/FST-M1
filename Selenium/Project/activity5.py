# Getting colors
#Goal: Get the color of the navigation menu

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
    #  Getting colors
    # Goal: Get the color of the navigation menu
    driver.find_element(By.ID, "user_name").send_keys("admin")
    driver.find_element(By.ID,"username_password").send_keys("pa$$w0rd")
    driver.find_element(By.XPATH,"//*[@id=\"bigbutton\"]").click()
    navigationmenuColor = driver.find_element(By.XPATH,"//*[@id=\"toolbar\"]").value_of_css_property("color")
    print("The  color of the navigation menu is: ", navigationmenuColor)
    