# adn3-p3-Superduo

## Football-Scores app

by CChevalier, October-December 2015.

### Changes after first submission  
- Add contentDescription to share button    
- Add translatable feature to dummy_data  
- Move some hardcoded strings to strings.xml    


### User Feedback

####UF1.  Your Boss says: "It's important to always use an API key when you can. Get your own API key and put it into the strings.xml file."  
        
    A personal API key shouldn't put in strings.xml or any other file that is made public (for instance commit to Github). Instead it's recommended to set it in local.properties (non committed file) and use Gradle feature to set it in due time   
    See this [Gist](https://gist.github.com/igortrncic/5058e49a8204e3b8a657)  
    
    Within you own local.properties file, please add a line like the following one:  
    API_KEY= "your api key"

    
####UF2.  Stefan says: �This app took me a while to figure out, but it is totally worth it! It helps me keep track of when to be glued to my TV, and keeps me up to date when I�m not.�
    
####UF3.  Moize� says: �I have trouble navigating and understanding this app. It is not accessible to those of us without perfect vision."
  
    See required component RC2 below.
    
####UF4.  Jennie says: �I like the functionality of this app, but I hate having to open it up every time I want to check for a new game. Can�t you put something on the home screen for us?�  
  
    See required component RC1 below.

        
### Required Components   

####RC1.  Football Scores can be displayed in a widget.  
    IMPLEMENTATION:   
    - See SingleScoresAppWidgetProvider.java and associated files    
    - Added scores widget will display game results based on local query defined within onUpdate() (2 possibles query)  
    
####RC2.  Football Scores app has content descriptions for all buttons.  
    FIX:  
    - only 2 imageViews in scores_list_item.xml had no content description.

####RC3.  Football Scores app supports layout mirroring.  
    FIX:  
    - supportsRTL added to AndroidManifest.xml  
    - xxxLeft  -> xxxLeft + xxxStart in layouts files  
    - xxxRight -> xxxLeft + xxxEnd  

    
## Additional References

### Android Developers Blog  
- [Native RTL support in Android 4.2](http://android-developers.blogspot.in/2013/03/native-rtl-support-in-android-42.html)  
- [Accessibility: Are You Serving All Your Users?](http://android-developers.blogspot.dk/2012/04/accessibility-are-you-serving-all-your.html)  
