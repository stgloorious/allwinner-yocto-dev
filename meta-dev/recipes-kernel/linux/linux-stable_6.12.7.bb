SUMMARY = "Linux stable v6.12.7"
COMPATIBLE_MACHINE = "olinuxino-a20"

inherit kernel

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

KERNEL_FEATURES:remove = "cfg/fs/vfat.scc"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;branch=linux-6.12.y;rev=v${PV} \
           file://0001-ARM-dts-sunxi-Add-MMC-alias-for-consistent-enumerati.patch \
           file://defconfig"

KCONFIG_MODE = "alldefconfig"

S="${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
LICENSE = "GPL-2.0-only"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
KERNEL_DEVICETREE = "allwinner/sun7i-a20-olinuxino-micro.dtb"
