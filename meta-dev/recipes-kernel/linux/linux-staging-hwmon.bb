SUMMARY = "The latest hwmon-next kernel"
COMPATIBLE_MACHINE = "olinuxino-a20"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/groeck/linux-staging.git;branch=hwmon-next \
           file://0001-enable-sts3x-dis.patch \
           file://enable-sht3x.cfg \
           file://defconfig \
"
SRC_URI[sha256sum] = "f9a4f91b609f7d332a5f2be01ab86336fa00149fae6bdc19f16fa19f78802d43"

S = "${WORKDIR}/git"
PV = "hwmon-next"
KERNEL_VERSION_SANITY_SKIP="1"
SRCREV = "${AUTOREV}"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
LICENSE = "GPL-2.0-only"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
KERNEL_DEVICETREE = "allwinner/sun7i-a20-olinuxino-micro.dtb"
