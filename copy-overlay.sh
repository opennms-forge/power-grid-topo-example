#!/bin/sh -e
if [ ! -d "$OPENNMS_HOME" ]; then
  echo "Invalid OPENNMS_HOME: '$OPENNMS_HOME'"
  exit 1
fi

if [ ! -e powergrid.xml ]; then
  echo "Could not find powergrid.xml"
  exit 1
fi

sudo mkdir -p "$OPENNMS_HOME/etc/graphml"
sudo mkdir -p "$OPENNMS_HOME/etc/graphml-edge-status"
sudo cp -R overlay/* "$OPENNMS_HOME/"
# Delete if already exist
curl -X DELETE -u admin:admin 'http://localhost:8980/opennms/rest/graphml/powergrid' > /dev/null 2>&1
sleep 15
curl -X POST -H "Content-Type: application/xml" -u admin:admin -d@powergrid.xml 'http://localhost:8980/opennms/rest/graphml/powergrid'
