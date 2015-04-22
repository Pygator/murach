#!/bin/bash

# Change to the directory that stores the database
cd /murach/java/db

# Start the Derby network server
java org.apache.derby.drda.NetworkServerControl start
