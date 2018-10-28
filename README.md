# PropertiesList
A simple Android Application that parses a JSON feed and displays the list and detail (for tablets) on to specific Fragments.

This app aims to:
- Utilise a basic Model-View-Presenter (MVP) Architecture
- Parse and handle data through Reactive Extensions (Rx)
- Handle orientation change
- Support devices with wide screens (tablets)
- Handle callbacks between fragment and the hosting activity

## App Architecture Design
The app UI consists of one fragment for regular devices and 2 fragments for devices with wide screens, all of which are hosted by a single host Activity. The fragments include:

- List - Uses a RecyclerView to list all the properties found
- Details - Displays the property Id of the selected property from this list


General app architecture shown below, where arrow represents data flow:
![img](https://i.imgur.com/n7eQo6X.png)

## Handling Device Rotation
As the activity gets recreated on device rotation, a methodology is required so that the property list data is retained and therefore another network call is not required. Just before the onPause(), onStop() and onDestroy() lifecycle methods are called, onSavedInstanceState method is called, and this is where PropertiesList is then seralized and placed in the Bundle object which is then to be unpacked and unseralized in the next onCreate(...).


## Supporting Tablets
Through the use of Fragments to display the UI, this give more design flexibility and also easily support tablets by delegating a specific layout for screens over a specific width (sw600dp chosen in this project).

The layout flexibility is done by abstracting both the list and detail fragment to one hosting Activity (FragmentHostActivity) and having a set phone and tablet activity xml layout. 

Through the use of alias resource (a resource that points to another resource), we can:
- Point to the phone activity layout for screens less than sw600dp
- Point to the tablet activity layout for screens more equal to or more than sw600dp.


## Libraries used
- RxJava2
- Retrofit2
- Glide
- Common Android Support Libraries

## References
https://github.com/googlesamples/android-architecture/tree/todo-mvp/
https://github.com/ribot/android-guidelines/blob/master/architecture_guidelines/android_architecture.md
Android Programming - The Big Nerd Ranch Guide 2nd Ed.
