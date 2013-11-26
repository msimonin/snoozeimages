snoozeimages
============

This is the snooze images system service. It exposes a RESTful API to deal with image management.

## Supported calls

`GET /images` : Gets the list of all the images in the repository backend.

`GET /images/[id]` : Gets the information of the image with given identifier.

`DELETE /images/[id]`: Delete the specified image.


## Image Repository backend

Snoozeimages is shipped with a default repository backend based on libvirt pool. 
This pool is shared accross all the computes nodes.

To use snoozeimages with another repository backend, specific drivers should be implemented.

## Development

Fork the repository
Make your bug fixes or feature additions by following our coding conventions (see the snoozecheckstyle repository)
Send a pull request

## Copyright

Snooze is copyrighted by INRIA and released under the GPL v2 license (see LICENSE.txt). It is registered at the APP (Agence de Protection des Programmes) under the number IDDN.FR.001.100033.000.S.P.2012.000.10000.
