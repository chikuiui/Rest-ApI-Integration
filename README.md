## Important Steps to Integrate Api into Android App :-

#### -> Create a Pojo class of what type of data we are getting from server.
#### -> Create a Api interface to provide functionalities like (@GET,@POST,@PUT,@PATCH).
#### -> Create a Retrofit Instance to connect the Api Interface into Retrofit using base URL.
#### -> In MainActivity create a retrofit instance of type (Api Interface)(2) and pass the Api Interface class as a parameter to it.
#### -> use MutableLiveData to get the response in Pojo object and observe that livedata and set it to adapter or view based on user requirement.
