# Flowutil built-in method

In the flowscript you can directly use the *util.method*, call the method in flowutil.

    //Omitting import

    public class FlowUtil {

        private static final  Logger LOG  =  LoggerFactory.getLogger(FlowUtil.class );

        private FlowUtil() {

        }
        private static FlowUtil util;
        public static FlowUtil getInstance() {
            if(util==null){
                util = new FlowUtil();
            }
            return util;
        }


        public Integer doubleToInt(double number) {
            return (int) number;
        }

        public String now( String format) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            String dateString = formatter.format(new Date());
            return dateString;
        }


        public String time(Object timestamp, String format) {
            if (timestamp == null) {
                return "";
            }
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            String dateString = formatter.format(timestamp);
            return dateString;
        }
        /**
        * 
        * @author liangpx
        * @Description: RSA uses the private key to decrypt, and the space in base64Message should be replaced with + before decryption.
        * @param base64Message
        * @param base64PrivateKey
        * @return
        */
        public String RSADecode(String base64Message,String base64PrivateKey) {
            String encryptValue = null;
            LOG.debug("{}",base64PrivateKey.length());
            try {

                byte decodeMessageBytes[] = Base64.decodeBase64(base64Message);
                byte[] keyBytes = Base64.decodeBase64(base64PrivateKey);
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);   
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");   
                PrivateKey privateKey = keyFactory.generatePrivate(keySpec);   
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
                encryptValue = new String(cipher.doFinal(decodeMessageBytes));
            } catch (Exception e) {
                    LOG.error(e.getMessage(),e);
            } 
            return encryptValue;
        }

        public String  md5(String content) {
            String md5 = "";
            try {
                md5 = bytesToMD5(content.getBytes(Constant.LANG_CODE));
            } catch (UnsupportedEncodingException e) {
                LOG.error(e.getMessage(),e);
            }
            return md5;
        }

        public  String bytesToHex(byte[] bytes) {
            StringBuilder md5str = new StringBuilder();
            // Replace each byte of the array with hexadecimal to form a md5 string
            int digital;
            for (int i = 0; i < bytes.length; i++) {
                digital = bytes[i];
                if (digital < 0) {
                    digital += 256;
                }
                if (digital < 16) {
                    md5str.append("0");
                }
                md5str.append(Integer.toHexString(digital));
            }
            return md5str.toString();
        }

        // Convert byte array to md5
        public  String bytesToMD5(byte[] input) {
            String md5str = null;
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] buff = md.digest(input);
                md5str = bytesToHex(buff);
            } catch (Exception e) {
                LOG.error(e.getMessage(),e);
            }
            return md5str;
        }


        public String getIP() {
            try {
                Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                while (en.hasMoreElements()) {
                    NetworkInterface intf = (NetworkInterface) en.nextElement();
                    Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();
                    while (enumIpAddr.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() 
                                    && inetAddress.isSiteLocalAddress()) {
                            return inetAddress.getHostAddress().toString();
                        }
                    }
                }
            }
            catch (SocketException e) {
                LOG.error(e.getMessage(),e);
            }
            return null;
        }


        /***Single server****/
        public void putTokenByOne(String mobile,String token){
            BaseFilter.putToken(mobile, token);
        }

        public void putDeviceByOne(String mobile,String token){
            BaseFilter.putDevice(mobile, token);
        }


        public void putIdByOne(String mobile,Object id){
            BaseFilter.putIdByOne(mobile, id);
        }

        public String getToken(String mobile){
            return BaseFilter.getToken(mobile);
        }

        public String getDevice(String mobile){
            return BaseFilter.getDevice(mobile);
        }


        public String getId(String mobile){
            return BaseFilter.getId(mobile);
        }

        //decode base64
        public String decodeBase64(String str) {
            try {
                byte[] buffer = Base64.decodeBase64(str);
                return new String(buffer, Constant.LANG_CODE);
            } catch (IOException e) {
                LOG.error(e.getMessage(),e);
                return null;
            }
        }
        //encode base64
        public String encodeBase64(String str) {
            try {
                return Base64.encodeBase64String(str.getBytes(Constant.LANG_CODE));
            } catch (IOException e) {
                LOG.error(e.getMessage(),e);
                return null;
            }
        }


        /**
        * GET Request
        *
        * @param url
        * @return
        */
        public  String httpGet(String url) {
            return new HttpUtil("10000").doGet(url);
        }

        /**
        * GET Request(With request parameters)
        * @param url
        * @return
        */
        public String httpPost(String url, Map<String, String> params) {

            if(params!=null && params.size()>0){
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                Set<String> keySet = params.keySet();
                for(String key : keySet) {
                    nvps.add(new BasicNameValuePair(key, params.get(key)));
                }
                return new HttpUtil("10000").doPost(url,nvps);
            }else {
                    return null;
            }
        }

        public String random(int length) {
            String result = "";
            java.util.Random r=new java.util.Random();
            for(int i=0;i<length;i++){
                result=result+String.valueOf(r.nextInt(10));
            }
            return result;
        }

        /** 
        * Reset sessionid, the data in the original session is automatically transferred to the new session
        * @param request 
        */  
        public void reSessionId(Context context){  
                HttpSession session = context.getRequest().getSession();  

                //First transfer the data in the original session to a temporary map
                Map<String,Object> tempMap = new HashMap<String,Object>();  
                Enumeration<String> sessionNames = session.getAttributeNames();  
                while(sessionNames.hasMoreElements()){  
                    String sessionName = sessionNames.nextElement();  
                    tempMap.put(sessionName, session.getAttribute(sessionName));  
                }  

                //Log out of the original session, in order to reset the sessionId 
                session.invalidate();  

                //Transfer data from the temporary map to the new session
                session = context.getRequest().getSession();  
                for(Map.Entry<String, Object> entry : tempMap.entrySet()){  

                        if(entry.getValue() instanceof Serializable) {
                            Serializable s = (Serializable) entry.getValue();
                        session.setAttribute(entry.getKey(), s);  
                        }

                }  


        }  

        public List<String> list(){
            return new ArrayList<String>();
        }

        public String getFileContent(String path) {
                BufferedReader reader = null;
                try {
                    StringBuilder buffer = new StringBuilder();
                    String line; 
                    reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
                    line = reader.readLine(); 
                    while (line != null) { 
                        buffer.append(line); 
                        line = reader.readLine(); 
                    }
                    return buffer.toString();
                }catch(Exception ex) {
                    LOG.error(ex.getMessage(),ex);
                    return null;
                }finally {
                    if(reader!=null) {
                        try {
                        reader.close();
                    } catch (IOException e) {
                        LOG.error(e.getMessage(),e);
                    }
                    }
                }
        }

    }