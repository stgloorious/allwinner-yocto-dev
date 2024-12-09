
UBOOT_ENV_SIZE ?= "0x10000"

do_deploy:append:sunxi() {
    ${B}/tools/mkenvimage -s ${UBOOT_ENV_SIZE} -o ${B}/${config}/uboot.env ${B}/${config}/u-boot-initial-env

    install -D -m 644 ${B}/${config}/uboot.env ${DEPLOYDIR}/uboot.env
}


