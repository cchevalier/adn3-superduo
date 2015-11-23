# adn3-p3-Superduo

## Alexandria app

by CChevalier, October 2015.


### User Feedback

####UF1.  Lauren says:
> “I like this app generally, and the speed at which books come up on my phone after I enter the ISBN is awesome. I’m frustrated that the scanning functionality isn’t implemented yet. That would speed up the whole process and make the app way more useful for me.”   
   
####UF2.  Josh says:
> “This app is terrible. They say you can scan books, but that functionality isn’t in the app yet. It also crashed on me when I tried to add the book my sister was reading on the flight to London.”
    
    
### Required Components  

####RC1.  Alexandria has barcode scanning functionality.

27/10/2015: First implementation using [ZXing / Scanning via intent](https://github.com/zxing/zxing/wiki/Scanning-Via-Intent)    
- require or will install ZXing bbarcode scanner at first launch  
- IntentIntegrator.java: Change: import android.app.Fragment to: import android.support.v4.app.Fragment;  

Tested on my Moto G 1st Gen.
 

   
####RC2.  Alexandria does not crash while searching for a book without an internet connection.  
  
FIX:  
- Add ACCESS_NETWORK_STATE permission to AndroidManifest  
- Implement a utility method isNetworkAvailable()  
- Add network indicator textView to fragment_add_book.xml (default and land)  
- Check against network activity at fragment onCreateView  
- Check against network activity when trying to fetch book info  
  
  
### References

#### Barcode scanning

- [ZXing](https://github.com/zxing/zxing)  
- [ZXing / Scanning Via Intent](https://github.com/zxing/zxing/wiki/Scanning-Via-Intent)  
- [barcodescanner](https://github.com/dm77/barcodescanner)


