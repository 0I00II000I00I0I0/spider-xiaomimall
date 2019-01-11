package cn.com.suosi.spider.xiaomimall.constant;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface SysConstant {

    String BASE_URL = "https://list.mi.com/";

    String productids = "10000123, 10000117, 10000118, 10000099, 10000100, 10000085, 10000111, 10000091, 8962, 10000089, null, 10000107, 10000103, 8274, 10000084, 6009, 7532, 8262, 6158, 7911, 7575, 6634, 8911, 5353, 8041, 8909, 6850, 7795, 8912, 8111, 6847, 7410, 5715, 8990, 7807, 8038, 7809, 8037, 8907, 8908, 7599, 7598, 10000115, 10000071, 10000114, 8883, 10000061, 5494, 10000113, 10000108, 1181300020, 1184500010, 5499, 8133, 8125, 4679, 1181300018, 5434, 1172700033, 1144600003, 1171600005, 1173700004, 1163000011, 5770, 1173700032, 1182400070, 1182400068, 1182400069, 1181500044, 1182000057, 1175000030, 1175000028, 8634, 7852, 2392, 1152800035, 3377, 1181800004, 1181800003, 1181800001, 1181800002, 1182100070, 1182100071, 1182200011, 1182200012, 1182200013, 1182200007, 1182200010, 1182200009, 1183500007, 1183500005, 1183500006, 1163400032, 1164400008, 7229, 7522, 1183000011, 1164000002, 1164000003, 1170600036, 4802, 1184500007, 4803, 4738, 5500, 3488, 1175100002, 1180800007, 1180800006, 1184400015, 1181300011, 3556, 1180900004, 1180900003, 1182400032, 1182400031, 1184900007, 1182400038, 3806, 2785, 1180500002, 6105, 3943, 1172100033, 7128, 5815, 1171900003, 5456, 1181800008, 8106, 1181600019, 1184200028, 7805, 1181600021, 4888, 7209, 1182000054, 1182000055, 1182400028, 1184200027, 7591, 1182400029, 1175200032, 1172000018, 1184300037, 9145, 8810, 8134, 4565, 1182600004, 8625, 1164800019, 1180200013, 1181300005, 4786, 6820, 1164800020, 1182600007, 1183900018, 1183900019, 10000101, 1183600004, 1183600005, 2774, 6079, 4984, 3922, 1180200020, 1174700032, 1180300046, 1174700046, 1154300012, 7792, 1182000043, 1182100028, 4942, 1171200026, 1171100018, 8914, 1164900029, 1164900028, 1164900030, 1164900032, 1164900031, 4949, 1171600028, 1170800025, 1170800026, 1184200031, 1184200032, 1184200033, 5184, 1163900105, 1171700007, 1170300031, 1162600048, 1162400011, 8026, 1182500054, 1183300012, 1183800003, 1182400030, 8321, 5469, 1173700021, 1180500004, 6526, 1181300008, 1174100028, 1174100027, 1173700020, 5468, 9120, 1184800002, 6802, 4998, 6271, 1180200004, 1184800013, 1180400001, 1180500020, 1181900033, 1184500014, 1184500015, 1164400032, 1164700050, 1171900017, 1173700017, 1184700001, 1174800012, 1182600001, 1154900055, 1172300020, 1162000038, 1182800031, 1182100072, 1180500018, 1190200015, 1190200014, 1172100023, 1184300031, 1172800036, 3459, 1170100002, 1174100029, 1174100030, 1180800004, 1180500019, 1183400004, 1184300029, 1154300033, 1155000010, 1174700013, 5051, 1174300023, 1174400012, 1174400008, 1182300051, 1181600008, 1181100003, 1182100021, 1184300025, 1182300044, 1182200004, 1182400074, 1183800050, 1190200026, 1185100028, 1182300048, 1183200006, 1181100002, 1183600008, 1183600007, 1184500021, 1184500023, 1184500022, 1184500009, 1183800048, 1183200005, 1180600003, 1182300050, 1182300047, 1181600007, 1190200025, 1181100006, 1182000058, 1184300028, 1185100027, 1180600002, 1184500013, 1182100020, 1182100019, 1182400072, 1182300043, 1183800049, 1183200002, 1162900025, 1182200003, 1182400073, 1183700011, 1183200003, 1181900022, 1183900034, 1185000010, 1181900021, 1162800009, 1162800007, 1134900277, 1154900068, 1171400004, 8881, 7797, 7129, 1184600021, 1184100022, 1184100021, 1184600020, 1180900012, 6103, 1181100014, 1172500007, 6443, 1183700023, 1184100024, 1184100023, 1173900006, 1184700005, 5297, 1945, 1171400001, 3674, 1181100021, 7602, 3807, 8108, 1183800015, 6010, 4674, 7851, 1182000033, 1183500002, 1182000032, 1182000034, 7601, 1183500004, 1183500003, 1174400056, 6527, 1180100015, 1184600016, 1181000030, 7769, 8999, 1183700025, 1182800028, 1181800009, 6007, 4072, 8107, 8878, 9029, 10000130, 7832, 5059, 5677, 1183700009, 4792, 8129, 7452, 1184800004, 1184300034, 4479, 7840, 6377, 1182700045, 1183100039, 1182100013, 6135, 1184300036, 1190100001, 5024, 5023, 7919, 1161200061, 1164800008, 1162200010, 1174300022, 1181900002, 2665, 3331, 2806, 5516, 1163100008, 1182900011, 9011, 6334, 1182800049, 1154400038, 1171900021, 1174200035, 1161100002, 1161200013, 1181200020, 1181200018, 1162500018, 1183000017, 1183000021, 1174200049, 6621, 4087, 1182300063, 6517, 1182300067, 1183900001, 1183800035, 8806, 1190100002, 1183800039, 1181800011, 1172900005, 7163, 1172800047, 1180500033, 1180500034, 7813, 7157, 1183800016, 1180500035, 1171700008, 1174200018, 1173100102, 1164700048, 1180900007, 1180900010, 1175000004, 4375, 4374, 1174400054, 1174400055, 1183800009, 1174400048, 1181300014, 1184300032, 1184300044, 1185100032, 1183800020, 1183800018, 6125, 6124, 1181900023, 1182400024, 7716, 1164700014, 1164700019, 1182500053, 1182600003, 1183800053, 1182800021, 1163200035, 1171000090, 1183200015, 1162000069, 1182100018, 1171200049, 4086, 1173400001, 1173900158";

    List<String> PRODUCT_IDS = Arrays.asList(productids.split(", "));

}
