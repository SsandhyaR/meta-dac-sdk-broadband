# meta-dac-sdk-broadband
SDK to create OCI image for RDK-B

  # Build instructions
      #following repo commands will required meta-layers see manifest of https://code.rdkcentral.com/r/plugins/gitiles/manifests/+/refs/heads/rdk-next/rdkb-extsrc.xml
      repo init -u https://code.rdkcentral.com/r/rdkcmf/manifests -m rdkb-extsrc.xml -b kirkstone

      #execute the below command to clone the projects
      sed -i '/oe-layers.xml/a  \ \ \ \ <project name="rdkcentral/meta-dac-sdk-broadband" remote="github" path="meta-dac-sdk-broadband" revision="main" /> \n\ \ \ \ <project name="yoctoproject/poky" remote="github" path="." revision="1e0d58c53b7d9c3feb631e46666ae7a3e3614253" upstream="kirkstone"/>' .repo/manifests/rdkb-extsrc.xml

      repo sync -j `nproc` --no-clone-bundle --no-tags

      # cherrypick the below link to overcome the old syntax override issue
      cd bitbake && git fetch https://code.rdkcentral.com/r/rdk/components/opensource/oe/bitbake refs/changes/35/85335/3 && git cherry-pick FETCH_HEAD && cd ..

      . ./oe-init-build-env
      cp ../meta-dac-sdk-broadband/manifests/bblayers.conf conf/

# Need to decide whether you compile Application binaries against ARM 32bit or x86 64bit, Select one of them
        # for ARMv7
        echo 'MACHINE = "raspberrypi4"' >> conf/local.conf
        # for ARCHv8
        echo 'MACHINE = "raspberrypi4-64"' >> conf/local.conf
        # for x86_64
        #echo 'MACHINE = "qemux86-64"' >> conf/local.conf


# Building Iperf DAC app
   bitbake dac-image-iperf3
