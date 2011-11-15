package Listener;


import java.util.*;
import java.io.File;
import java.lang.ref.WeakReference;


/**
* Class for monitoring changes in disk files.
* Usage:
*
* 1. Implement the FileListener interface.
* 2. Create a FileMonitor instance.
* 3. Add the file(s)/directory(ies) to listen for.
*
* fileChanged() will be called when a monitored file is created,
* deleted or its modified time changes.
*/
public class FileMonitor
{
private Timer timer_;
private HashMap files_; // File -> Long
private Collection listeners_; // of WeakReference(FileListener)


public FileMonitor (long pollingInterval)
{
files_ = new HashMap();
listeners_ = new ArrayList();

timer_ = new Timer (true);
timer_.schedule (new FileMonitorNotifier(), 0, pollingInterval);
}


public void stop()
{
timer_.cancel();
}


public void addFile (File file)
{
if (!files_.containsKey (file)) {
long modifiedTime = file.exists() ? file.lastModified() : -1;
files_.put (file, new Long (modifiedTime));
}
}


public void removeFile (File file)
{
files_.remove (file);
}


public void addListener (FileListener fileListener)
{
// Don't add if its already there
for (Iterator i = listeners_.iterator(); i.hasNext(); ) {
WeakReference reference = (WeakReference) i.next();
FileListener listener = (FileListener) reference.get();
if (listener == fileListener)
return;
}

// Use WeakReference to avoid memory leak if this becomes the
// sole reference to the object.
listeners_.add (new WeakReference (fileListener));
}


public void removeListener (FileListener fileListener)
{
for (Iterator i = listeners_.iterator(); i.hasNext(); ) {
WeakReference reference = (WeakReference) i.next();
FileListener listener = (FileListener) reference.get();
if (listener == fileListener) {
i.remove();
break;
}
}
}


private class FileMonitorNotifier extends TimerTask
{
public void run()
{
// Loop over the registered files and see which have changed.
// Use a copy of the list in case listener wants to alter the
// list within its fileChanged method.
Collection files = new ArrayList (files_.keySet());

for (Iterator i = files.iterator(); i.hasNext(); ) {
File file = (File) i.next();
long lastModifiedTime = ((Long) files_.get (file)).longValue();
long newModifiedTime = file.exists() ? file.lastModified() : -1;

// Chek if file has changed
if (newModifiedTime != lastModifiedTime) {

// Register new modified time
files_.put (file, new Long (newModifiedTime));

// Notify listeners
for (Iterator j = listeners_.iterator(); j.hasNext(); ) {
WeakReference reference = (WeakReference) j.next();
FileListener listener = (FileListener) reference.get();

// Remove from list if the back-end object has been GC'd
if (listener == null)
j.remove();
else
listener.fileChanged (file);
}
}
}
}
}
}

