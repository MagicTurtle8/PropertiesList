# PropertiesList
A simple Android Application that parses a JSON feed and displays the list and detail (for tablets) on to specific Fragments.

This app aims to:
- Utilise a basic Model-View-Presenter (MVP) Architecture
- Parse and handle data through Reactive Extensions (Rx)
- Handle orientation change
- Support devices with wide screens (tablets)
- Handle callbacks between fragment and the hosting activity

## App Design
The app UI consists of one fragment for regular devices and 2 fragments for devices with wide screens, all of which are hosted by a single host Activity. The fragments include:

- List - Uses a RecyclerView to list all the properties found
- Details - Displays the property Id of the selected property from this list

## Libraries used
- RxJava2
- Glide
- Common Android Support Libraries

## References
https://github.com/googlesamples/android-architecture/tree/todo-mvp/
