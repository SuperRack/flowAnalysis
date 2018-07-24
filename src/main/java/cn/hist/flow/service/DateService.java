package cn.hist.flow.service;

import java.util.List;

import cn.hist.flow.domain.BarData;
import cn.hist.flow.domain.Data;
import cn.hist.flow.domain.LineData;
import cn.hist.flow.domain.PicData;

public interface DateService {

	List<String> findProvince();

	List<BarData> findUpDownByPro(Data data);

	List<PicData> findFlowByPcPicUp(String flowYear);

	List<PicData> findFlowByPcPicDown(String flowYear);

	List<LineData> findFlowByLineUp(String flowYear);

	List<LineData> findFlowByLineDown(String flowYear);
}
