# AZ-204
Practical examples of AZ-204 exercises

## WEBAPP
In this section we will explore a way of uploading a basic web application using CLI

### Log in
First of all you need to be logged in a valid account with an active subscription.
if your account doesn't have a subscription you can create it in [azure portal](https://portal.azure.com)

You can try the simple command:

`az login`

if you are facing problems using az login, perhaps you should use device code authentication
To do so:

```
 az config set core.encrypt_token_cache=false
 az account clear 
 az config set core.encrypt_token_cache=true
 ```

and then:

` az login --use-device-code `

### Uploading your web application
go to the html folder where your webapp is located and execute?

` az webapp up -g %resourceGroup% -n %appName% --htm `

in case you don't know what resource group you have, you can check it in  [azure portal](https://portal.azure.com) or use the following command instead:

` az group list --query "[].{id:name}" -o tsv`


## FUNCTION

first of all you will need to have Azure Core tools in order to test your function effectively, you can download it directly from azure: [azure core tools](https://learn.microsoft.com/en-us/azure/azure-functions/functions-run-local?tabs=windows%2Cisolated-process%2Cnode-v4%2Cpython-v2%2Chttp-trigger%2Ccontainer-apps&pivots=programming-language-csharp)

### Dependencies
after following the steps to install, you can open VS Code, by typing F1 you can create an Azure Function. Selecting this option will give you a ready to go template, but don't be surprised if it doesn't parse your JSONS properly. To handle JSON properly we used the jackson binding dependency.

```
<dependencies>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.18.3</version>
    </dependency>
</dependencies>
```

for testing we needed maven sure fire plugin, in this example we won't explore further details about testing.
```
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.19.1</version>
    </plugin>
</plugins>
```
### Coding
Basically to use it we created Person.class with the standart format of the JSON. With one attribute only. And after that we used the class "ObjectMapper" from Jackson Binding to fill our class Person. 

### Executing
To test it locally you can go to the terminal in VS Code and press F5, this will turn your function active and it now can be accessed either by POSTMAN or within the AZURE tab in VSCODE.

If you don't have Azure package installed in your VS CODE, have a look in the extensions tab and download/install it.

In the Azure tab, select Local Project-> Function -> The name of your Function. It will be asked to type the body of your request, and thats about it. You now have successfully executed your function locally.