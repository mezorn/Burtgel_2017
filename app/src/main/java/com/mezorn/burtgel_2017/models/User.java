package com.mezorn.burtgel_2017.models;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by manlai on 5/27/17.
 */
@RealmClass
public class User extends RealmObject {

    private String id;
    private String          name;
    private int             age;
    private String gender;
    private String register;
    private String address;

    /*
    * Error:Execution failed for task ':app:transformClassesWithMultidexlistForDebug'.
> java.io.IOException: Can't write intermediates/multi-dex/debug/componentClasses.jar (Can't read .gradle/caches/modules-2/files-2.1/com.google.code.gson/gson/2.8.0/ gson-2.8.0.jar] (Duplicate zip entry [gson-2.8.0.jar:com/google/gson/annotations/Expose.class]))
    * */









}
