package com.example.demo.service;
import java.util.List;

import com.example.demo.model.Visitor;

public interface VisitorService {
    public Visitor createVisitor(Visitor visitor);
    public Visitor getVisitorById(Long id);
    List<Visitor> getAllVisitors();
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RiskRule;

public interface RiskRuleService {
    public RiskRule creatRule(RiskRule rule);
    public List<RiskRule> getAllRules();
    public RiskRule getRule(long id);

    
}
package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RiskScore;

public interface RiskScoreService {
    public RiskScore evaluateVisitor(Long visitorId); 
    public RiskScore getScoreForVisitor(Long visitorid);
    public List<RiskScore> getAllRules();

}
package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RiskScore;

public interface RiskScoreService {
    public RiskScore evaluateVisitor(Long visitorId); 
    public RiskScore getScoreForVisitor(Long visitorid);
    public List<RiskScore> getAllRules();

}
