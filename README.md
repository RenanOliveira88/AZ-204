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

