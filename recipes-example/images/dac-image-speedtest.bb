SUMMARY = "DAC Container with SDL speedtest application"

inherit  dac-image-base

IMAGE_INSTALL = "rdk-speedtest-cli"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/RefSpeedtestClient"
APP_METADATA_PATH = "metadatas/speedtest-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "rdkcentral"
OCI_IMAGE_AUTHOR_EMAIL = "info@rdkcentral.com"
OCI_IMAGE_ENTRYPOINT_ARGS = "192.168.128.1\@-p\@5201\@-t\@15\@-b\@200\@-P\@6"

OCI_IMAGE_WORKINGDIR = "/"

ROOTFS_POSTPROCESS_COMMAND += "remove_libstd_from_rootfs;"

remove_libstd_from_rootfs() {
    rm -f ${IMAGE_ROOTFS}/usr/lib/libstdc++.so.6
}
