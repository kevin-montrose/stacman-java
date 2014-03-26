stacman-java
============

This is a java wrapper around the [Stack Exchange API](https://api.stackexchange.com/) which is currently at version 2.2.

It's the base library used in the [Stack Exchange android application](https://play.google.com/store/apps/details?id=com.stackexchange.marvin) and is used for the vast majority of the application.

To get started, simply add this is a dependent library on your project and initiate a `StacManClient` object using your API key from the link above. You can then add an access token to the object by calling `setAccessToken` after which you can call the (new to 2.2) write methods, or access `/me` URLs.
