#Get the url of the header image

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
    # Get the url of the header image
    url = driver.find_element(By.XPATH, "//*[@id=\"form\"]/div[1]/img").get_attribute("src")
    print("URL of the header image is: ", url)
