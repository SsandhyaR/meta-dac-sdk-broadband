SUMMARY = "DAC Container with SDL iperf3 application"

inherit  dac-image-iperf3

IMAGE_INSTALL = "iperf3"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/iperf3"
APP_METADATA_PATH = "metadatas/iperf3-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "rdkcentral"
OCI_IMAGE_AUTHOR_EMAIL = "info@rdkcentral.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/" 
